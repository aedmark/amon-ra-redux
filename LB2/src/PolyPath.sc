;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 945)
(include sci.sh)
(use Main)
(use Motion)
(use System)

(class PolyPath of Motion
	(properties
		name {PolyPath}
		value 2
		points 0
		finalX 0
		finalY 0
		obstacles 0
	)

	(method (init param1 param2 param3 param4 param5 param6 &tmp [temp0 30])
		(if argc
			(= client param1)
			(if (> argc 1)
				(cond
					((>= argc 6)
						(= obstacles param6)
					)
					((not (IsObject obstacles))
						(= obstacles (gCurRoom obstacles:))
					)
				)
				(if points
					(Memory memFREE points)
				)
				(= points
					(AvoidPath
						(param1 x:)
						(param1 y:)
						(= finalX param2)
						(= finalY param3)
						(if obstacles
							(obstacles elements:)
						else
							0
						)
						(if obstacles
							(obstacles size:)
						else
							0
						)
						(if (>= argc 5) param5 else 1)
					)
				)
				(if (> argc 3)
					(= caller param4)
				)
			)
			(self setTarget:)
		)
		(super init:)
	)

	(method (dispose)
		(if points
			(Memory memFREE points)
		)
		(= points 0)
		(super dispose:)
	)

	(method (moveDone)
		(if (== (WordAt points value) 30583)
			(super moveDone:)
		else
			(self setTarget: init:)
		)
	)

	(method (setTarget &tmp temp0 temp1 temp2 temp3 [temp4 30])
		(if (!= (WordAt points value) 30583)
			(= x (WordAt points value))
			(= y (WordAt points (++ value)))
			(++ value)
			(if (and (IsObject global95) (= temp3 (global95 size:)))
				(= temp0
					(AvoidPath
						(client x:)
						(client y:)
						x
						y
						(global95 elements:)
						temp3
						0
					)
				)
				(= temp1 (WordAt temp0 2))
				(= temp2 (WordAt temp0 3))
				(if (or (!= x temp1) (!= y temp2))
					(= x temp1)
					(= y temp2)
					(Memory memPOKE (+ points value 2) 30583)
				)
				(Memory memFREE temp0)
			)
		)
	)
)
