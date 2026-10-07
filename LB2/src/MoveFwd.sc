;;; Sierra Script 1.0 - (do not remove this comment)
(script# 951)
(include sci.sh)
(use PolyPath)


(class MoveFwd of PolyPath
	(properties
		sel_20 {MoveFwd}
		sel_42 0
		sel_143 0
		sel_1 0
		sel_0 0
		sel_43 0
		sel_44 0
		sel_45 0
		sel_46 0
		sel_47 0
		sel_48 0
		sel_49 0
		sel_50 0
		sel_240 0
		sel_249 0
		sel_250 0
		sel_74 2
		sel_87 0
		sel_257 0
		sel_258 0
		sel_259 0
	)
	
	(method (sel_110 param1 param2 param3)
		(if argc
			(super
				sel_110:
					param1
					(+ (param1 sel_1?) (SinMult (param1 sel_55?) param2))
					(- (param1 sel_0?) (CosMult (param1 sel_55?) param2))
					(if (>= argc 3) param3 else 0)
			)
		else
			(super sel_110:)
		)
	)
)
