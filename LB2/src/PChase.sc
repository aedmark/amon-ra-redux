;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 930)
(include sci.sh)
(use Main)
(use PolyPath)
(use System)

(class PChase of PolyPath
	(properties
		name {PChase}
		who 0
		distance 0
		targetX 0
		targetY 0
	)

	(method (init param1 param2 param3 param4 param5)
		(cond
			((>= argc 5)
				(= obstacles param5)
			)
			((not (IsObject obstacles))
				(= obstacles (gCurRoom obstacles:))
			)
		)
		(if (>= argc 1)
			(= client param1)
			(if (>= argc 2)
				(= who param2)
				(= targetX (who x:))
				(= targetY (who y:))
				(if (>= argc 3)
					(= distance param3)
					(if (>= argc 4)
						(= caller param4)
					)
				)
			)
		)
		(super init: client targetX targetY caller 1 obstacles)
	)

	(method (doit &tmp temp0)
		(cond
			(
				(>
					(GetDistance
						targetX
						targetY
						(who x:)
						(who y:)
					)
					distance
				)
				(if points
					(Memory memFREE points)
				)
				(= points 0)
				(= value 2)
				(self init: client who)
			)
			((<= (= temp0 (client distanceTo: who)) distance)
				(self moveDone:)
			)
			(else
				(super doit:)
			)
		)
	)

	(method (moveDone &tmp temp0)
		(cond
			((<= (= temp0 (client distanceTo: who)) distance)
				(super moveDone:)
			)
			((== (WordAt points value) 30583)
				(if points
					(Memory memFREE points)
				)
				(= points 0)
				(= value 2)
				(self init: client who)
			)
			(else
				(self init:)
			)
		)
	)
)

(class PFollow of PolyPath
	(properties
		name {PFollow}
		who 0
		distance 0
		targetX 0
		targetY 0
	)

	(method (init param1 param2 param3 param4 &tmp temp0)
		(= temp0
			(if (>= argc 4)
				param4
			else
				(gCurRoom obstacles:)
			)
		)
		(if (>= argc 1)
			(= client param1)
			(if (>= argc 2)
				(= who param2)
				(= targetX (who x:))
				(= targetY (who y:))
				(if (>= argc 3)
					(= distance param3)
				)
			)
		)
		(super init: client targetX targetY 0 1 temp0)
	)

	(method (doit &tmp temp0 temp1)
		(cond
			(
				(>
					(GetDistance
						targetX
						targetY
						(who x:)
						(who y:)
					)
					distance
				)
				(if points
					(Memory memFREE points)
				)
				(= points 0)
				(= value 2)
				(self init: client who)
				0
			)
			((<= (= temp0 (client distanceTo: who)) distance)
				(= temp1
					(GetAngle
						(client x:)
						(client y:)
						(who x:)
						(who y:)
					)
				)
				(if (!= (client heading:) temp1)
					(client setHeading: temp1)
				)
				(= xLast (client x:))
				(= yLast (client y:))
				(= b-moveCnt gGameTime)
				0
			)
			(else
				(super doit:)
			)
		)
	)

	(method (moveDone)
		(self init:)
	)
)
