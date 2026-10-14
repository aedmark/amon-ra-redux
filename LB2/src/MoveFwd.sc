;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 951)
(include sci.sh)
(use PolyPath)

(class MoveFwd of PolyPath
	(properties
		name {MoveFwd}
	)

	(method (init param1 param2 param3)
		(if argc
			(super
				init:
					param1
					(+ (param1 x:) (SinMult (param1 heading:) param2))
					(- (param1 y:) (CosMult (param1 heading:) param2))
					(if (>= argc 3) param3 else 0)
			)
		else
			(super init:)
		)
	)
)
