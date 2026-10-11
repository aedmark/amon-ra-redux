;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 951)
(include sci.sh)
(use PolyPath)

(class MoveFwd of PolyPath
	(properties
		sel_20 {MoveFwd}
	)

	(method (sel_110 param1 param2 param3)
		(if argc
			(super
				sel_110:
					param1
					(+ (param1 sel_1:) (SinMult (param1 sel_55:) param2))
					(- (param1 sel_0:) (CosMult (param1 sel_55:) param2))
					(if (>= argc 3) param3 else 0)
			)
		else
			(super sel_110:)
		)
	)
)
