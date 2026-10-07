;;; Sierra Script 1.0 - (do not remove this comment)
(script# 935)
(include sci.sh)
(use Print)
(use Obj)


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
	
	(method (sel_110 theSel_42 theSel_577 theSel_578 theSel_575 theSel_576)
		(if argc
			(= sel_42 theSel_42)
			(= sel_577 theSel_577)
			(= sel_578 theSel_578)
			(= sel_575 theSel_575)
			(= sel_576 theSel_576)
		)
		(= sel_579 (- sel_577 sel_578))
		(if (not (= sel_580 (- sel_575 sel_576)))
			(proc921_0 {<Scaler> frontY cannot be equal to backY})
			(return 0)
		)
		(= sel_581 (- sel_578 (/ (* sel_579 sel_576) sel_580)))
		(return (self sel_57:))
	)
	
	(method (sel_57 &tmp sel_42Sel_0 theSel_578)
		(cond 
			((< (= sel_42Sel_0 (sel_42 sel_0?)) sel_576) (= theSel_578 sel_578))
			((> sel_42Sel_0 sel_575) (= theSel_578 sel_577))
			(else
				(= theSel_578
					(+ (/ (* sel_579 sel_42Sel_0) sel_580) sel_581)
				)
			)
		)
		(= theSel_578 (/ (* theSel_578 128) 100))
		(sel_42 sel_104: theSel_578 sel_105: theSel_578)
	)
)
