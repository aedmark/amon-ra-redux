;;; Sierra Script 1.0 - (do not remove this comment)
(script# 939)
(include sci.sh)
(use Cycle)


(class Osc of Cycle
	(properties
		sel_20 {Osc}
		sel_42 0
		sel_143 0
		sel_239 1
		sel_158 0
		sel_240 0
		sel_469 -1
	)
	
	(method (sel_110 param1 theSel_469 theSel_143)
		(if (>= argc 2)
			(= sel_469 theSel_469)
			(if (>= argc 3) (= sel_143 theSel_143))
		)
		(super sel_110: param1)
	)
	
	(method (sel_57 &tmp oscSel_241)
		(if
			(or
				(> (= oscSel_241 (self sel_241:)) (sel_42 sel_246:))
				(< oscSel_241 0)
			)
			(= sel_239 (- sel_239))
			(self sel_242:)
		else
			(sel_42 sel_4: oscSel_241)
		)
	)
	
	(method (sel_242)
		(if sel_469
			(sel_42 sel_4: (self sel_241:))
			(if (> sel_469 0) (-- sel_469))
		else
			(= sel_240 1)
			(self sel_243:)
		)
	)
)
