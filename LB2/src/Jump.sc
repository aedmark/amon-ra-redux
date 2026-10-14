;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 991)
(include sci.sh)
(use Main)
(use Motion)

(class Jump of Motion
	(properties
		name {Jump}
		x 20000
		y 20000
		gx 0
		gy 3
		xStep 20000
		yStep 0
		signal 0
		illegalBits 0
		waitApogeeX 1
		waitApogeeY 1
	)

	(method (init param1 param2 &tmp temp0)
		(= client param1)
		(if (== argc 2)
			(= caller param2)
		)
		(= illegalBits (client illegalBits:))
		(= signal (client signal:))
		(client illegalBits: 0 setPri:)
		(if (== xStep 20000)
			(= xStep
				(cond
					(
						(or
							(> (= temp0 (client heading:)) 330)
							(< temp0 30)
							(and (< 150 temp0) (< temp0 210))
						)
						0
					)
					((< temp0 180)
						(client xStep:)
					)
					(else
						(- (client xStep:))
					)
				)
			)
		)
		(if (not (and waitApogeeX (< (* xStep gx) 0)))
			(= waitApogeeX 0)
		)
		(if (not (and waitApogeeY (< (* yStep gy) 0)))
			(= waitApogeeY 0)
		)
		(= b-moveCnt gGameTime)
		(self setTest:)
	)

	(method (doit &tmp temp0 temp1)
		(if (>= (Abs (- gGameTime b-moveCnt)) (client moveSpeed:))
			(= b-moveCnt gGameTime)
			(= xLast (client x:))
			(= yLast (client y:))
			(client x: (+ xLast xStep) y: (+ yLast yStep))
			(= temp0 xStep)
			(= temp1 yStep)
			(+= xStep gx)
			(+= yStep gy)
			(if
				(and
					(not waitApogeeX)
					(!= x 20000)
					(<= 0 (* dx (- (client x:) x)))
				)
				(client x: x)
				(self moveDone:)
				(return)
			)
			(if
				(and
					(not waitApogeeY)
					(!= y 20000)
					(<= 0 (* dy (- (client y:) y)))
				)
				(client y: y)
				(self moveDone:)
				(return)
			)
			(if (<= (* temp0 xStep) 0)
				(= waitApogeeX 0)
				(self setTest:)
			)
			(if (<= (* temp1 yStep) 0)
				(= waitApogeeY 0)
				(self setTest:)
			)
		)
	)

	(method (moveDone)
		(client illegalBits: illegalBits signal: signal)
		(if caller
			(= gDoMotionCue 1)
			(= completed 1)
		)
	)

	(method (motionCue)
		(client mover: 0)
		(if (and completed (IsObject caller))
			(caller cue:)
		)
		(self dispose:)
	)

	(method (setTest)
		(= dx
			(if
				(or
					(> (client x:) x)
					(and (== (client x:) x) (> xStep 0))
				)
				-1
			else
				1
			)
		)
		(= dy
			(if
				(or
					(> (client y:) y)
					(and (== (client y:) y) (> yStep 0))
				)
				-1
			else
				1
			)
		)
	)
)

(class JumpTo of Jump
	(properties
		name {JumpTo}
	)

	(method (init param1 param2 param3 param4 &tmp temp0 temp1 [temp2 52])
		(= client param1)
		(= x param2)
		(= y param3)
		(if (and (== x (param1 x:)) (== y (param1 y:)))
			(= illegalBits (client illegalBits:))
			(= signal (client signal:))
			(self moveDone:)
			(return)
		)
		(= temp0 (- x (param1 x:)))
		(= temp1 (- y (param1 y:)))
		(SetJump self temp0 temp1 gy)
		(if (not temp0)
			(= x 20000)
		)
		(if (not temp1)
			(= y 20000)
		)
		(switch argc
			(3
				(super init: param1)
			)
			(4
				(super init: param1 param4)
			)
		)
	)

	(method (moveDone)
		(if (!= x 20000)
			(client x: x)
		)
		(if (!= y 20000)
			(client y: y)
		)
		(super moveDone:)
	)
)
