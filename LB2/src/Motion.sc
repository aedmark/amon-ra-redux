;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 992)
(include sci.sh)
(use Main)
(use System)

(class Cycle of Obj
	(properties
		name {Cycle}
		client 0
		caller 0
		cycleDir 1
		cycleCnt 0
		completed 0
	)

	(method (init param1)
		(if argc
			(= client param1)
		)
		(= cycleCnt (- (- gGameTime (client cycleSpeed:)) 1))
		(= completed 0)
	)

	(method (nextCel)
		(return
			(if (< (Abs (- gGameTime cycleCnt)) (client cycleSpeed:))
				(client cel:)
			else
				(= cycleCnt gGameTime)
				(+ (client cel:) cycleDir)
			)
		)
	)

	(method (cycleDone))

	(method (motionCue)
		(client cycler: 0)
		(if (and completed (IsObject caller))
			(caller cue:)
		)
		(self dispose:)
	)
)

(class Fwd of Cycle
	(properties
		name {Fwd}
	)

	(method (doit &tmp temp0)
		(if (> (= temp0 (self nextCel:)) (client lastCel:))
			(self cycleDone:)
		else
			(client cel: temp0)
		)
	)

	(method (cycleDone)
		(client cel: 0)
	)
)

(class Walk of Fwd
	(properties
		name {Walk}
	)

	(method (doit &tmp temp0)
		(if (not (client isStopped:))
			(super doit:)
		)
	)
)

(class CT of Cycle
	(properties
		name {CT}
		endCel 0
	)

	(method (init param1 param2 param3 param4 &tmp temp0)
		(super init: param1)
		(= cycleDir param3)
		(if (== argc 4)
			(= caller param4)
		)
		(= endCel
			(if (> param2 (= temp0 (client lastCel:))) temp0 else param2)
		)
	)

	(method (doit &tmp temp0 temp1)
		(if (> endCel (= temp1 (client lastCel:)))
			(= endCel temp1)
		)
		(= temp0 (self nextCel:))
		(client
			cel:
				(cond
					((> temp0 temp1) 0)
					((< temp0 0) temp1)
					(else temp0)
				)
		)
		(if (and (== gGameTime cycleCnt) (== endCel (client cel:)))
			(self cycleDone:)
		)
	)

	(method (cycleDone)
		(= completed 1)
		(if caller
			(= gDoMotionCue 1)
		else
			(self motionCue:)
		)
	)
)

(class End of CT
	(properties
		name {End}
	)

	(method (init param1 param2)
		(super
			init: param1 (param1 lastCel:) 1 (if (== argc 2) param2 else 0)
		)
	)
)

(class Beg of CT
	(properties
		name {Beg}
	)

	(method (init param1 param2)
		(super init: param1 0 -1 (if (== argc 2) param2 else 0))
	)
)

(class SyncWalk of Fwd
	(properties
		name {SyncWalk}
		xLast 0
		yLast 0
	)

	(method (doit &tmp temp0)
		(if
			(and
				(IsObject (= temp0 (client mover:)))
				(or (!= (client x:) xLast) (!= (client y:) yLast))
			)
			(= xLast (client x:))
			(= yLast (client y:))
			(super doit:)
		)
	)

	(method (nextCel)
		(= cycleCnt (+ gGameTime (client cycleSpeed:)))
		(super nextCel:)
	)
)

(class Motion of Obj
	(properties
		name {Motion}
		client 0
		caller 0
		x 0
		y 0
		dx 0
		dy 0
		b-moveCnt 0
		b-i1 0
		b-i2 0
		b-di 0
		b-xAxis 0
		b-incr 0
		completed 0
		xLast 0
		yLast 0
	)

	(method (init param1 param2 param3 param4 &tmp [temp0 2] temp2 temp3)
		(if (>= argc 1)
			(= client param1)
			(if (>= argc 2)
				(= x param2)
				(if (>= argc 3)
					(= y param3)
					(if (>= argc 4)
						(= caller param4)
					)
				)
			)
		)
		(= yLast (= xLast (= completed 0)))
		(= b-moveCnt (+ 1 (client moveSpeed:) gGameTime))
		(if (= temp3 (client cycler:))
			(temp3 cycleCnt: b-moveCnt)
		)
		(if
			(GetDistance
				(= temp2 (client x:))
				(= temp3 (client y:))
				x
				y
			)
			(client setHeading: (GetAngle temp2 temp3 x y))
		)
		(InitBresen self)
	)

	(method (doit &tmp [temp0 6])
		(if (>= (Abs (- gGameTime b-moveCnt)) (client moveSpeed:))
			(= b-moveCnt gGameTime)
			(DoBresen self)
		)
	)

	(method (moveDone)
		(= completed 1)
		(if caller
			(= gDoMotionCue 1)
		else
			(self motionCue:)
		)
	)

	(method (setTarget param1 param2)
		(if argc
			(= x param1)
			(= y param2)
		)
	)

	(method (onTarget)
		(return
			(if (== (client x:) x)
				(== (client y:) y)
			else
				0
			)
		)
	)

	(method (motionCue)
		(client mover: 0)
		(if (and completed (IsObject caller))
			(caller cue:)
		)
		(self dispose:)
	)
)

(class MoveTo of Motion
	(properties
		name {MoveTo}
	)

	(method (init)
		(super init: &rest)
	)

	(method (onTarget)
		(return
			(if (<= (Abs (- (client x:) x)) (client xStep:))
				(<= (Abs (- (client y:) y)) (client yStep:))
			else
				0
			)
		)
	)
)
