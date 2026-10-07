;;; Sierra Script 1.0 - (do not remove this comment)
(script# 969)
(include sci.sh)
(use Cycle)


(class Rev of Cycle
	(properties
		sel_20 {Rev}
		sel_42 0
		sel_143 0
		sel_239 -1
		sel_158 0
		sel_240 0
	)
	
	(method (sel_57 &tmp revSel_241)
		(if (< (= revSel_241 (self sel_241:)) 0)
			(self sel_242:)
		else
			(sel_42 sel_4: revSel_241)
		)
	)
	
	(method (sel_242)
		(sel_42 sel_4: (sel_42 sel_246:))
	)
)
