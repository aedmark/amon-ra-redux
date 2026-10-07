;;; Sierra Script 1.0 - (do not remove this comment)
(script# 956)
(include sci.sh)
(use Cycle)


(class ForwardCounter of Fwd
	(properties
		sel_20 {ForwardCounter}
		sel_42 0
		sel_143 0
		sel_239 1
		sel_158 0
		sel_240 0
		sel_467 0
	)
	
	(method (sel_110 param1 theSel_467 theSel_143)
		(super sel_110: param1)
		(if (>= argc 2)
			(= sel_467 theSel_467)
			(if (>= argc 3) (= sel_143 theSel_143))
		)
	)
	
	(method (sel_242)
		(if (-- sel_467)
			(super sel_242:)
		else
			(= sel_240 1)
			(self sel_243:)
		)
	)
)
