;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 998)
(include sci.sh)
(use Main)
(use Print)
(use PolyPath)
(use Feature)
(use Motion)
(use System)

(class View of Feature
	(properties
		name {View}
		yStep 2
		view -1
		loop 0
		cel 0
		priority 0
		underBits 0
		signal 257
		lsTop 0
		lsLeft 0
		lsBottom 0
		lsRight 0
		brTop 0
		brLeft 0
		brBottom 0
		brRight 0
		palette 0
		scaleSignal 0
		scaleX 128
		scaleY 128
		maxScale 128
	)

	(method (init &tmp temp0)
		(= temp0 (if (& signal $0020) gAddToPics else gCast))
		(&= signal $7fff)
		(if (not (temp0 contains: self))
			(= lsRight (= lsBottom (= lsLeft (= lsTop 0))))
			(&= signal $ff77)
		)
		(BaseSetter self)
		(temp0 add: self)
		(if (== temp0 gAddToPics)
			(if (not (& signal $0010))
				(= priority (CoordPri y))
			)
			(SetNowSeen self)
			(temp0 doit:)
		)
		(self initialize: checkDetail:)
	)

	(method (dispose)
		(self startUpd: hide:)
		(|= signal $8000)
	)

	(method (showSelf)
		(Print addText: name addIcon: view loop cel init:)
	)

	(method (isNotHidden)
		(return (not (& signal $0088)))
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
				((& signal $0080) 0)
				((and (not (IsObject onMeCheck)) (& signal $1000))
					(if
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
						(not
							(IsItSkip
								view
								loop
								cel
								(- temp1 nsTop)
								(- temp0 nsLeft)
							)
						)
					)
				)
				(else
					(super onMe: temp0 temp1)
				)
			)
		)
	)

	(method (posn param1 param2 param3)
		(if (>= argc 1)
			(= x param1)
			(if (>= argc 2)
				(= y param2)
				(if (>= argc 3)
					(= z param3)
				)
			)
		)
		(BaseSetter self)
		(self forceUpd:)
	)

	(method (stopUpd)
		(|= signal $0001)
		(&= signal $fffd)
	)

	(method (forceUpd)
		(|= signal $0040)
	)

	(method (startUpd)
		(|= signal $0002)
		(&= signal $fffe)
	)

	(method (setPri param1)
		(cond
			((== argc 0)
				(|= signal $0010)
			)
			((== param1 -1)
				(&= signal $ffef)
			)
			(else
				(= priority param1)
				(|= signal $0010)
			)
		)
		(self forceUpd:)
	)

	(method (setLoop param1)
		(cond
			((== argc 0)
				(|= signal $0800)
			)
			((== param1 -1)
				(&= signal $f7ff)
			)
			(else
				(= loop param1)
				(|= signal $0800)
			)
		)
		(self forceUpd:)
	)

	(method (setCel param1)
		(cond
			((== argc 0) 0)
			((== param1 -1) 0)
			(else
				(= cel
					(if (>= param1 (self lastCel:))
						(self lastCel:)
					else
						param1
					)
				)
			)
		)
		(self forceUpd:)
	)

	(method (ignoreActors param1)
		(if (or (== 0 argc) param1)
			(|= signal $4000)
		else
			(&= signal $bfff)
		)
	)

	(method (hide)
		(|= signal $0008)
	)

	(method (show)
		(&= signal $fff7)
	)

	(method (delete)
		(if (& signal $8000)
			(&= signal $7fff)
			(cond
				((gAddToPics contains: self)
					(gAddToPics delete: self)
					(&= signal $ffdf)
				)
				((& signal $0020)
					(gCast delete: self)
					(gAddToPics add: self)
					(return)
				)
				(else
					(gCast delete: self)
				)
			)
			(if underBits
				(UnLoad 133 underBits)
				(= underBits 0)
			)
			(super dispose:)
			(if (IsObject actions)
				(actions dispose:)
			)
			(= actions 0)
		)
	)

	(method (addToPic)
		(if (gCast contains: self)
			(|= signal $8021)
		else
			(|= signal $0020)
			(self init:)
		)
	)

	(method (lastCel)
		(return (- (NumCels self) 1))
	)

	(method (isExtra param1 &tmp temp0)
		(= temp0 (& signal $0200))
		(if argc
			(if param1
				(|= signal $0200)
			else
				(&= signal $fdff)
			)
		)
		(return temp0)
	)

	(method (motionCue))

	(method (checkDetail))

	(method (setScale param1 &tmp temp0 temp1 temp2 [temp3 40])
		(cond
			((not argc)
				(= scaleSignal 1)
			)
			((not param1)
				(= scaleSignal 0)
			)
			((< param1 (gCurRoom vanishingY:))
				(Printf
					@temp3
					{<%s setScale:> y value less than vanishingY}
					name
				)
			)
			(else
				(= temp0 (- param1 (gCurRoom vanishingY:)))
				(= temp2 (+ (/ (* (= temp1 (- 190 param1)) 100) temp0) 100))
				(|= scaleSignal $0003)
				(= maxScale (/ (* temp2 128) 100))
			)
		)
	)
)

(class Prop of View
	(properties
		name {Prop}
		signal 0
		cycleSpeed 6
		script 0
		cycler 0
		timer 0
		detailLevel 0
		scaler 0
	)

	(method (doit &tmp temp0)
		(SetNowSeen self nsTop)
		(if (& signal $8000)
			(return)
		)
		(if script
			(script doit:)
		)
		(if (and (& signal $0004) (not (& signal $0002)))
			(return)
		)
		(if cycler
			(cycler doit:)
		)
		(if scaler
			(scaler doit:)
		)
	)

	(method (handleEvent param1)
		(if script
			(script handleEvent: param1)
		)
		(super handleEvent: param1)
	)

	(method (delete)
		(if (& signal $8000)
			(self setScript: 0 setCycle: 0)
			(if timer
				(timer dispose:)
			)
			(if (IsObject scaler)
				(scaler dispose:)
				(= scaler 0)
			)
			(super delete:)
		)
	)

	(method (motionCue)
		(if (and cycler (cycler completed:))
			(cycler motionCue:)
		)
	)

	(method (checkDetail param1)
		(cond
			((not detailLevel))
			(
				(<
					(if argc
						param1
					else
						(gGame detailLevel:)
					)
					detailLevel
				)
				(self stopUpd:)
			)
			(cycler
				(self startUpd:)
			)
		)
	)

	(method (setScale param1 param2 &tmp [temp0 40])
		(if scaler
			(scaler dispose:)
			(= scaler 0)
		)
		(cond
			((not argc)
				(= scaleSignal 1)
			)
			((IsObject param1)
				(= scaleSignal 1)
				(= scaler
					(if (& (param1 -info-:) $8000)
						(param1 new:)
					else
						param1
					)
				)
				(scaler init: self param2 &rest)
			)
			((== param1 -1)
				(if (param2 scaleSignal:)
					(= scaleSignal (param2 scaleSignal:))
					(= maxScale (param2 maxScale:))
					(if (IsObject (param2 scaler:))
						((= scaler ((param2 scaler:) new:)) client: self)
					)
				)
			)
			(else
				(super setScale: param1)
			)
		)
	)

	(method (setCycle param1)
		(if cycler
			(cycler dispose:)
		)
		(if param1
			(self startUpd:)
			(= cycler
				(if (& (param1 -info-:) $8000)
					(param1 new:)
				else
					param1
				)
			)
			(cycler init: self &rest)
		else
			(= cycler 0)
		)
	)

	(method (setScript param1)
		(if (IsObject script)
			(script dispose:)
		)
		(if param1
			(param1 init: self &rest)
		)
	)

	(method (cue)
		(if script
			(script cue:)
		)
	)
)

(class Actor of Prop
	(properties
		name {Actor}
		illegalBits -32768
		xLast 0
		yLast 0
		xStep 3
		origStep 770
		moveSpeed 6
		blocks 0
		baseSetter 0
		mover 0
		looper 0
		viewer 0
		avoider 0
		code 0
	)

	(method (init)
		(super init: &rest)
		(= xLast x)
		(= yLast y)
	)

	(method (doit &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
		(if (& signal $8000)
			(return)
		)
		(if script
			(script doit:)
		)
		(if code
			(code doit: self)
		)
		(if (and (& signal $0004) (not (& signal $0002)))
			(return)
		)
		(if viewer
			(viewer doit: self)
		)
		(cond
			(avoider
				(avoider doit:)
			)
			(mover
				(mover doit:)
				(if (& scaleSignal $0001)
					(= temp5 (>> origStep $0008))
					(= temp6 (& origStep $00ff))
					(= temp3 (/ (+ (/ (* temp5 scaleX 10) 128) 5) 10))
					(= temp4 (/ (+ (/ (* temp6 scaleY 10) 128) 5) 10))
					(if (or (!= temp3 xStep) (!= temp4 yStep))
						(if (< temp3 1)
							(= temp3 1)
						)
						(if (< temp4 1)
							(= temp4 1)
						)
						(self setStep: temp3 temp4 1)
					)
				)
			)
		)
		(if scaler
			(scaler doit:)
		)
		(if cycler
			(= temp1 brLeft)
			(= temp2 brRight)
			(cycler doit:)
			(if baseSetter
				(baseSetter doit: self)
			else
				(BaseSetter self)
			)
			(if (and (or (!= temp1 brLeft) (!= temp2 brRight)) (self cantBeHere:))
				(self findPosn:)
			)
		)
		(= xLast x)
		(= yLast y)
	)

	(method (posn param1 param2)
		(super posn: param1 param2 &rest)
		(= xLast param1)
		(= yLast param2)
		(if (self cantBeHere:)
			(self findPosn:)
		)
	)

	(method (setLoop param1 &tmp temp0)
		(if
			(= temp0
				(cond
					((== argc 0)
						(super setLoop:)
						0
					)
					((not (IsObject param1))
						(super setLoop: param1 &rest)
						0
					)
					((& (param1 -info-:) $8000)
						(param1 new:)
					)
					(else param1)
				)
			)
			(if looper
				(looper dispose:)
			)
			((= looper temp0) init: self &rest)
		)
	)

	(method (delete)
		(if (& signal $8000)
			(if (!= mover -1)
				(self setMotion: 0)
			)
			(self setAvoider: 0)
			(if baseSetter
				(baseSetter dispose:)
				(= baseSetter 0)
			)
			(if looper
				(looper dispose:)
				(= looper 0)
			)
			(if viewer
				(viewer dispose:)
				(= viewer 0)
			)
			(if blocks
				(blocks dispose:)
				(= blocks 0)
			)
			(if code
				(code dispose:)
				(= code 0)
			)
			(if (IsObject actions)
				(actions dispose:)
				(= actions 0)
			)
			(super delete:)
		)
	)

	(method (motionCue)
		(if (and mover (mover completed:))
			(mover motionCue:)
		)
		(super motionCue:)
	)

	(method (checkDetail param1)
		(cond
			((not detailLevel))
			(
				(<
					(if argc
						param1
					else
						(gGame detailLevel:)
					)
					detailLevel
				)
				(self stopUpd:)
			)
			((or cycler mover)
				(self startUpd:)
			)
		)
	)

	(method (setMotion param1)
		(if (and mover (!= mover -1))
			(mover dispose:)
		)
		(if param1
			(self startUpd:)
			(= mover
				(if (& (param1 -info-:) $8000)
					(param1 new:)
				else
					param1
				)
			)
			(mover init: self &rest)
		else
			(= mover 0)
		)
	)

	(method (setAvoider param1)
		(if avoider
			(avoider dispose:)
		)
		(= avoider
			(if (and (IsObject param1) (& (param1 -info-:) $8000))
				(param1 new:)
			else
				param1
			)
		)
		(if avoider
			(avoider init: self &rest)
		)
	)

	(method (ignoreHorizon param1)
		(if (or (not argc) param1)
			(|= signal $2000)
		else
			(&= signal $dfff)
		)
	)

	(method (observeControl param1 &tmp temp0)
		(for ((= temp0 0)) (< temp0 argc) ((++ temp0))
			(|= illegalBits [param1 temp0])
		)
	)

	(method (ignoreControl param1 &tmp temp0)
		(for ((= temp0 0)) (< temp0 argc) ((++ temp0))
			(&= illegalBits (~ [param1 temp0]))
		)
	)

	(method (observeBlocks)
		(if (not blocks)
			(= blocks (Set new:))
		)
		(blocks add: &rest)
	)

	(method (ignoreBlocks)
		(blocks delete: &rest)
		(if (blocks isEmpty:)
			(blocks dispose:)
			(= blocks 0)
		)
	)

	(method (isStopped)
		(return
			(if (not (IsObject mover))
			else
				(and (== x (mover xLast:)) (== y (mover yLast:)))
			)
		)
	)

	(method (isBlocked)
		(return (& signal $0400))
	)

	(method (findPosn &tmp [temp0 5]))

	(method (inRect param1 param2 param3 param4)
		(return
			(if (and (<= param1 x) (< x param3) (<= param2 y))
				(< y param4)
			else
				0
			)
		)
	)

	(method (onControl param1)
		(if (and argc param1)
			(OnControl CONTROL x y)
		else
			(OnControl CONTROL brLeft brTop brRight brBottom)
		)
	)

	(method (distanceTo param1)
		(GetDistance x y (param1 x:) (param1 y:) gPerspective)
	)

	(method (cantBeHere &tmp temp0)
		(if baseSetter
			(baseSetter doit: self)
		else
			(BaseSetter self)
		)
		(= temp0
			(cond
				((CantBeHere self (gCast elements:)))
				(
					(and
						(not (& signal $2000))
						(IsObject gCurRoom)
						(< y (gCurRoom horizon:))
					)
					-1
				)
				((and blocks (not (blocks allTrue: 57 self))) -2)
			)
		)
	)

	(method (setStep param1 param2 param3 &tmp temp0 temp1)
		(= temp0 (>> origStep $0008))
		(= temp1 (& origStep $00ff))
		(if (and (>= argc 1) (!= param1 -1))
			(= temp0 param1)
		)
		(if (and (>= argc 2) (!= param2 -1))
			(= temp1 param2)
		)
		(if (or (< argc 3) (not param3))
			(= origStep (+ (<< temp0 $0008) temp1))
		)
		(= xStep temp0)
		(= yStep temp1)
		(if
			(and
				(IsObject mover)
				(or (mover isMemberOf: MoveTo) (mover isMemberOf: PolyPath))
			)
			(mover init:)
		)
	)

	(method (setDirection param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7)
		(= temp0
			(if (== (= temp1 (gCurRoom vanishingY:)) -30000)
				x
			else
				(gCurRoom vanishingX:)
			)
		)
		(if (and (== xStep 0) (== yStep 0))
			(return)
		)
		(= temp5 (/ 32000 (Max xStep yStep)))
		(switch param1
			(0
				(self setMotion: 0)
				(return)
			)
			(1
				(= temp2 (- temp0 x))
				(= temp3 (- temp1 y))
			)
			(5
				(= temp2 (- x temp0))
				(= temp3 (- y temp1))
			)
			(3
				(= temp2 temp5)
				(= temp3 0)
			)
			(7
				(= temp2 (- temp5))
				(= temp3 0)
			)
			(else
				(if (< 180 (= temp4 (GetAngle x y temp0 temp1)))
					(-= temp4 360)
				)
				(= temp4 (+ (/ (+ temp4 90) 2) (* 45 (- param1 2))))
				(= temp2 (SinMult temp4 100))
				(= temp3 (- (CosMult temp4 100)))
			)
		)
		(/= temp5 5)
		(while (and (< (Abs temp3) temp5) (< (Abs temp2) temp5))
			(*= temp2 5)
			(*= temp3 5)
		)
		(if (and (= temp7 (gCurRoom obstacles:)) gUseObstacles)
			(= temp6
				(AvoidPath
					x
					y
					(+ x temp2)
					(+ y temp3)
					(temp7 elements:)
					(temp7 size:)
					0
				)
			)
			(= temp2 (- (WordAt temp6 2) x))
			(= temp3 (- (WordAt temp6 3) y))
			(Memory memFREE temp6)
		)
		(cond
			((or temp2 temp3)
				(self setMotion: PolyPath (+ x temp2) (+ y temp3))
			)
			(param1
				(self setMotion: 0 setHeading: (* (- param1 1) 45))
			)
			(else
				(self setMotion: 0)
			)
		)
	)

	(method (setHeading param1 param2)
		(if argc
			(= heading param1)
		)
		(if looper
			(looper doit: self heading (if (>= argc 2) param2 else 0))
		else
			(DirLoop self heading)
			(if (and (>= argc 2) (IsObject param2))
				(param2 cue: &rest)
			)
		)
		(return heading)
	)
)
