;;; Sierra Script 1.0 - (do not remove this comment)
(script# 967)
(include sci.sh)
(use DIcon)
(use Cycle)


(class DCIcon of DIcon
	(properties
		sel_20 {DCIcon}
		sel_31 4
		sel_29 0
		sel_6 0
		sel_7 0
		sel_8 0
		sel_9 0
		sel_21 0
		sel_72 0
		sel_74 0
		sel_2 0
		sel_3 0
		sel_4 0
		sel_245 0
		sel_244 6
		sel_14 0
	)
	
	(method (sel_110)
		((= sel_245 (Fwd sel_109:)) sel_110: self)
	)
	
	(method (sel_111)
		(if sel_245 (sel_245 sel_111:))
		(super sel_111:)
	)
	
	(method (sel_186 &tmp theSel_4)
		(if sel_245
			(= theSel_4 sel_4)
			(sel_245 sel_57:)
			(if (!= sel_4 theSel_4) (self sel_80:))
		)
	)
	
	(method (sel_246)
		(return (- (NumCels self) 1))
	)
)
