;;; Sierra Script 1.0 - (do not remove this comment)
(script# 961)
(include sci.sh)
(use Cycle)

(public
	StopWalk 0
)

(class StopWalk of Fwd
	(properties
		sel_20 {StopWalk}
		sel_42 0
		sel_143 0
		sel_239 1
		sel_158 0
		sel_240 0
		sel_451 0
		sel_452 0
	)
	
	(method (sel_110 theSel_42 theSel_452)
		(if argc
			(= sel_451 ((= sel_42 theSel_42) sel_2?))
			(if (>= argc 2) (= sel_452 theSel_452))
		)
		(super sel_110: sel_42)
		(self sel_57:)
	)
	
	(method (sel_57 &tmp sel_42Sel_3 sel_42Sel_56)
		(if (sel_42 sel_247:)
			(cond 
				(
					(and
						(== sel_452 -1)
						(!= (sel_42 sel_3?) (- (NumLoops sel_42) 1))
					)
					(= sel_42Sel_3 (sel_42 sel_3?))
					(if
						(and
							(= sel_42Sel_56 (sel_42 sel_56?))
							(not (sel_42Sel_56 sel_240?))
						)
						(sel_42 sel_312: 0)
					)
					(super sel_57:)
					(sel_42
						sel_3: (- (NumLoops sel_42) 1)
						sel_156: sel_42Sel_3
					)
				)
				(
				(and (!= sel_452 -1) (== (sel_42 sel_2?) sel_451))
					(sel_42 sel_2: sel_452)
					(if
						(and
							(= sel_42Sel_56 (sel_42 sel_56?))
							(not (sel_42Sel_56 sel_240?))
						)
						(sel_42 sel_312: 0)
					)
					(super sel_57:)
				)
				((!= sel_452 -1) (super sel_57:))
			)
		else
			(switch sel_452
				((sel_42 sel_2?)
					(sel_42 sel_2: sel_451)
				)
				(-1
					(sel_42 sel_155: -1 sel_156: -1)
					(if (== (sel_42 sel_3?) (- (NumLoops sel_42) 1))
						(sel_42 sel_3: (sel_42 sel_4?) sel_4: 0)
					)
				)
			)
			(super sel_57:)
		)
	)
	
	(method (sel_111)
		(if (== (sel_42 sel_2?) sel_452)
			(sel_42 sel_2: sel_451)
		)
		(super sel_111:)
	)
)
