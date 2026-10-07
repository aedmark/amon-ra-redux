;;; Sierra Script 1.0 - (do not remove this comment)
(script# 919)
(include sci.sh)
(use PolyPath)


(class PApproach of PolyPath
	(properties
		sel_20 {PApproach}
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
		sel_254 20
		sel_272 0
		sel_273 0
	)
	
	(method (sel_110 theSel_42 theSel_254)
		(if (>= argc 1)
			(= sel_42 theSel_42)
			(if (>= argc 2)
				(if (IsObject [theSel_254 0])
					(= sel_272 ([theSel_254 0] sel_1?))
					(= sel_273 ([theSel_254 0] sel_0?))
					(if (>= argc 3)
						(= sel_254 [theSel_254 1])
						(if (>= argc 4) (= sel_143 [theSel_254 2]))
					)
				else
					(= sel_272 [theSel_254 0])
					(= sel_273 [theSel_254 1])
					(if (>= argc 4)
						(= sel_254 [theSel_254 2])
						(if (>= argc 5) (= sel_143 [theSel_254 3]))
					)
				)
			)
			(super sel_110: sel_42 sel_272 sel_273 sel_143)
		else
			(super sel_110:)
		)
	)
	
	(method (sel_252)
		(return
			(<=
				(GetDistance
					(sel_42 sel_1?)
					(sel_42 sel_0?)
					sel_272
					sel_273
				)
				sel_254
			)
		)
	)
)
