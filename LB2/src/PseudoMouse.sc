;;; Sierra Script 1.0 - (do not remove this comment)
(script# 933)
(include sci.sh)
(use Main)
(use Obj)


(class PseudoMouse of Code
	(properties
		sel_20 {PseudoMouse}
		sel_525 2
		sel_526 2
		sel_527 20
		sel_344 0
		sel_528 5
	)
	
	(method (sel_57 &tmp temp0 temp1)
		(= temp0 (global24 sel_1?))
		(= temp1 (global24 sel_0?))
		(switch sel_344
			(1 (= temp1 (- temp1 sel_525)))
			(2
				(= temp0 (+ temp0 sel_525))
				(= temp1 (- temp1 sel_525))
			)
			(3 (= temp0 (+ temp0 sel_525)))
			(4
				(= temp0 (+ temp0 sel_525))
				(= temp1 (+ temp1 sel_525))
			)
			(5 (= temp1 (+ temp1 sel_525)))
			(6
				(= temp0 (- temp0 sel_525))
				(= temp1 (+ temp1 sel_525))
			)
			(7 (= temp0 (- temp0 sel_525)))
			(8
				(= temp0 (- temp0 sel_525))
				(= temp1 (- temp1 sel_525))
			)
		)
		(gGame sel_197: gSel_582 1 temp0 temp1)
	)
	
	(method (sel_133 param1 &tmp temp0 theSel_344 temp2)
		(= temp0 (param1 sel_31?))
		(= theSel_344 (param1 sel_37?))
		(= temp2 (param1 sel_61?))
		(return
			(if (& temp0 $0040)
				(if
					(or
						(not gIconBar)
						(!= (gIconBar sel_207?) (gIconBar sel_228?))
					)
					(= sel_344 theSel_344)
				else
					(return 0)
				)
				(= sel_525
					(if (& temp0 $0004)
						(if (& temp2 $0003) sel_526 else sel_527)
					else
						sel_528
					)
				)
				(cond 
					((& temp0 $0004)
						(if sel_344
							(self sel_57:)
						else
							(return (param1 sel_73: 0))
						)
					)
					(sel_344 (self sel_134:))
					(else (self sel_167:))
				)
				(return (param1 sel_73: 1))
			else
				0
			)
		)
	)
	
	(method (sel_134 theSel_344)
		(if argc (= sel_344 theSel_344))
		(gTheDoits sel_118: self)
	)
	
	(method (sel_167)
		(= sel_344 0)
		(gTheDoits sel_81: self)
	)
)
