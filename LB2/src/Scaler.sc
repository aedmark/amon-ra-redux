;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 935)
(include sci.sh)
(use Print)
(use System)

(class Scaler of Code
	(properties
		sel_20 {Scaler}
		sel_42 0
		sel_575 190
		sel_576 0
		sel_577 100
		sel_578 0
		sel_579 0
		sel_580 0
		sel_581 0
	)

	(method (sel_110 param1 param2 param3 param4 param5)
		(if argc
			(= sel_42 param1)
			(= sel_577 param2)
			(= sel_578 param3)
			(= sel_575 param4)
			(= sel_576 param5)
		)
		(= sel_579 (- sel_577 sel_578))
		(if (not (= sel_580 (- sel_575 sel_576)))
			(Prints {<Scaler> frontY cannot be equal to backY})
			(return 0)
		)
		(= sel_581 (- sel_578 (/ (* sel_579 sel_576) sel_580)))
		(return (self sel_57:))
	)

	(method (sel_57 &tmp temp0 temp1)
		(cond
			((< (= temp0 (sel_42 sel_0:)) sel_576)
				(= temp1 sel_578)
			)
			((> temp0 sel_575)
				(= temp1 sel_577)
			)
			(else
				(= temp1 (+ (/ (* sel_579 temp0) sel_580) sel_581))
			)
		)
		(= temp1 (/ (* temp1 128) 100))
		(sel_42 sel_104: temp1 sel_105: temp1)
	)
)
