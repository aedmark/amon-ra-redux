;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 919)
(include sci.sh)
(use PolyPath)

(class PApproach of PolyPath
	(properties
		name {PApproach}
		distance 20
		targetX 0
		targetY 0
	)

	(method (init param1 param2 param3 param4 param5)
		(if (>= argc 1)
			(= client param1)
			(if (>= argc 2)
				(if (IsObject param2)
					(= targetX (param2 x:))
					(= targetY (param2 y:))
					(if (>= argc 3)
						(= distance param3)
						(if (>= argc 4)
							(= caller param4)
						)
					)
				else
					(= targetX param2)
					(= targetY param3)
					(if (>= argc 4)
						(= distance param4)
						(if (>= argc 5)
							(= caller param5)
						)
					)
				)
			)
			(super init: client targetX targetY caller)
		else
			(super init:)
		)
	)

	(method (onTarget)
		(return
			(<=
				(GetDistance (client x:) (client y:) targetX targetY)
				distance
			)
		)
	)
)
