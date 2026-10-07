;;; Sierra Script 1.0 - (do not remove this comment)
(script# 945)
(include sci.sh)
(use Main)
(use Cycle)
(use Obj)


(class PolyPath of Motion
	(properties
		sel_20 {PolyPath}
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
	
	(method (sel_110 theSel_42 theSel_257 theSel_258 theSel_143 param5 theSel_259 &tmp [temp0 30])
		(if argc
			(= sel_42 theSel_42)
			(if (> argc 1)
				(cond 
					((>= argc 6) (= sel_259 theSel_259))
					((not (IsObject sel_259)) (= sel_259 (global2 sel_259?)))
				)
				(if sel_87 (Memory memFREE sel_87))
				(= sel_87
					(AvoidPath
						(theSel_42 sel_1?)
						(theSel_42 sel_0?)
						(= sel_257 theSel_257)
						(= sel_258 theSel_258)
						(if sel_259 (sel_259 sel_24?) else 0)
						(if sel_259 (sel_259 sel_86?) else 0)
						(if (>= argc 5) param5 else 1)
					)
				)
				(if (> argc 3) (= sel_143 theSel_143))
			)
			(self sel_251:)
		)
		(super sel_110:)
	)
	
	(method (sel_111)
		(if sel_87 (Memory memFREE sel_87))
		(= sel_87 0)
		(super sel_111:)
	)
	
	(method (sel_97)
		(if (== (proc999_6 sel_87 sel_74) 30583)
			(super sel_97:)
		else
			(self sel_251: sel_110:)
		)
	)
	
	(method (sel_251 &tmp temp0 theSel_1 theSel_0 gListSel_109Sel_86 [temp4 30])
		(if (!= (proc999_6 sel_87 sel_74) 30583)
			(= sel_1 (proc999_6 sel_87 sel_74))
			(= sel_0 (proc999_6 sel_87 (++ sel_74)))
			(++ sel_74)
			(if
				(and
					(IsObject gListSel_109)
					(= gListSel_109Sel_86 (gListSel_109 sel_86?))
				)
				(= temp0
					(AvoidPath
						(sel_42 sel_1?)
						(sel_42 sel_0?)
						sel_1
						sel_0
						(gListSel_109 sel_24?)
						gListSel_109Sel_86
						0
					)
				)
				(= theSel_1 (proc999_6 temp0 2))
				(= theSel_0 (proc999_6 temp0 3))
				(if (or (!= sel_1 theSel_1) (!= sel_0 theSel_0))
					(= sel_1 theSel_1)
					(= sel_0 theSel_0)
					(Memory memPOKE (+ sel_87 sel_74 2) 30583)
				)
				(Memory memFREE temp0)
			)
		)
	)
)
