;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 950)
(include sci.sh)
(use Main)
(use PApproach)
(use System)

(class CueObj of Script
	(properties
		name {CueObj}
		theVerb 0
	)

	(method (changeState param1)
		(switch (= state param1)
			(1
				(gEgo
					setHeading:
						(GetAngle
							(gEgo x:)
							(gEgo y:)
							(client x:)
							(client y:)
						)
						self
				)
				(gTheDoits add: self)
			)
			(2
				(= cycles 3)
			)
			(3
				(gTheDoits delete: self)
				(if
					(not
						(and
							client
							(IsObject (client actions:))
							((client actions:) doVerb: theVerb)
						)
					)
					(client doVerb: theVerb)
				)
				(= state 0)
			)
		)
	)
)

(class Feature of Obj
	(properties
		name {Feature}
		x 0
		y 0
		z 0
		heading 0
		noun 0
		modNum -1
		nsTop 0
		nsLeft 0
		nsBottom 0
		nsRight 0
		sightAngle 26505
		actions 0
		onMeCheck 26505
		approachX 0
		approachY 0
		approachDist 0
		_approachVerbs 0
	)

	(method (init param1)
		(self initialize: (if argc param1 else 0))
		(if (self respondsTo: 5)
			(gCast add: self)
		else
			(gFeatures add: self)
		)
	)

	(method (dispose)
		(if actions
			(actions dispose:)
			(= actions 0)
		)
		(if (IsObject onMeCheck)
			(onMeCheck dispose:)
			(= onMeCheck 0)
		)
		(gFeatures delete: self)
		(super dispose:)
	)

	(method (initialize param1)
		(cond
			((and argc param1)
				(self perform: param1)
			)
			(gFtrInitializer
				(self perform: gFtrInitializer)
			)
		)
	)

	(method (handleEvent param1 &tmp temp0)
		(cond
			((param1 claimed:)
				(return 1)
			)
			(
				(and
					(& (param1 type:) $4000)
					(self onMe: param1)
					(self isNotHidden:)
				)
				(CueObj
					state: 0
					cycles: 0
					client: self
					theVerb: (param1 message:)
				)
				(param1 claimed: 1)
				(if
					(and
						(gUser canControl:)
						(>
							(GetDistance
								(gEgo x:)
								(gEgo y:)
								approachX
								approachY
							)
							approachDist
						)
						gLb2ApproachCode
						(& _approachVerbs (gLb2ApproachCode doit: (param1 message:)))
					)
					(gEgo
						setMotion:
							PApproach
							approachX
							(+ (gEgo z:) approachY)
							approachDist
							CueObj
					)
				else
					(gEgo setMotion: 0)
					(if (self facingMe:)
						(CueObj changeState: 3)
					)
				)
			)
		)
		(return (param1 claimed:))
	)

	(method (doVerb param1 &tmp temp0 temp1)
		(= temp0 (if gDoVerbCode gDoVerbCode else dftDoVerb))
		(if (== modNum -1)
			(= modNum gCurRoomNum)
		)
		(if (and gMsgType (Message msgGET modNum noun param1 0 1))
			(gMessager say: noun param1 0 0 0 modNum)
		else
			(temp0 doit: param1 self)
		)
	)

	(method (notFacing &tmp temp0)
		(gEgo setMotion: 0)
		(CueObj client: self state: 0 cycles: 0 cue:)
	)

	(method (facingMe param1 &tmp temp0 temp1)
		(= temp0 (if argc param1 else gEgo))
		(if
			(>
				(= temp1
					(Abs
						(-
							(GetAngle (temp0 x:) (temp0 y:) x y)
							(temp0 heading:)
						)
					)
				)
				180
			)
			(= temp1 (- 360 temp1))
		)
		(if (<= temp1 sightAngle)
			(return 1)
		else
			(if (!= sightAngle 26505)
				(self notFacing:)
			)
			(return 0)
		)
	)

	(method (isNotHidden)
		(return 1)
	)

	(method (onMe param1 param2 &tmp temp0 temp1)
		(if (IsObject param1)
			(= temp0 (param1 x:))
			(= temp1 (param1 y:))
		else
			(= temp0 param1)
			(= temp1 param2)
		)
		(return
			(cond
				((IsObject onMeCheck)
					(AvoidPath temp0 temp1 onMeCheck)
				)
				(
					(or
						(not
							(if (or nsLeft nsRight nsTop)
							else
								nsBottom
							)
						)
						(and
							(<= nsLeft temp0)
							(<= temp0 nsRight)
							(<= nsTop temp1)
							(<= temp1 nsBottom)
						)
					)
					(if (!= onMeCheck 26505)
						(& onMeCheck (OnControl CONTROL temp0 temp1))
					else
						1
					)
				)
			)
		)
	)

	(method (approachVerbs param1 &tmp temp0 temp1)
		(= _approachVerbs 0)
		(if (and argc gLb2ApproachCode param1)
			(for ((= temp0 0)) (< temp0 argc) ((++ temp0))
				(= temp1 (gLb2ApproachCode doit: [param1 temp0]))
				(self _approachVerbs: (| (self _approachVerbs:) temp1))
			)
		)
	)
)

(instance dftDoVerb of Code
	(properties
		name {dftDoVerb}
	)

	(method (doit)
		(return 1)
	)
)

(class Actions of Code
	(properties
		name {Actions}
	)

	(method (doVerb)
		(return 0)
	)
)
