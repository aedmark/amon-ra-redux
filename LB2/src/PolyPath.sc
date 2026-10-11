;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 945)
(include sci.sh)
(use Main)
(use Motion)
(use System)

(class PolyPath of Motion
	(properties
		sel_20 {PolyPath}
		sel_74 2
		sel_87 0
		sel_257 0
		sel_258 0
		sel_259 0
	)

	(method (sel_110 param1 param2 param3 param4 param5 param6 &tmp [temp0 30])
		(if argc
			(= sel_42 param1)
			(if (> argc 1)
				(cond
					((>= argc 6)
						(= sel_259 param6)
					)
					((not (IsObject sel_259))
						(= sel_259 (gCurRoom sel_259:))
					)
				)
				(if sel_87
					(Memory memFREE sel_87)
				)
				(= sel_87
					(AvoidPath
						(param1 sel_1:)
						(param1 sel_0:)
						(= sel_257 param2)
						(= sel_258 param3)
						(if sel_259
							(sel_259 sel_24:)
						else
							0
						)
						(if sel_259
							(sel_259 sel_86:)
						else
							0
						)
						(if (>= argc 5) param5 else 1)
					)
				)
				(if (> argc 3)
					(= sel_143 param4)
				)
			)
			(self sel_251:)
		)
		(super sel_110:)
	)

	(method (sel_111)
		(if sel_87
			(Memory memFREE sel_87)
		)
		(= sel_87 0)
		(super sel_111:)
	)

	(method (sel_97)
		(if (== (WordAt sel_87 sel_74) 30583)
			(super sel_97:)
		else
			(self sel_251: sel_110:)
		)
	)

	(method (sel_251 &tmp temp0 temp1 temp2 temp3 [temp4 30])
		(if (!= (WordAt sel_87 sel_74) 30583)
			(= sel_1 (WordAt sel_87 sel_74))
			(= sel_0 (WordAt sel_87 (++ sel_74)))
			(++ sel_74)
			(if (and (IsObject global95) (= temp3 (global95 sel_86:)))
				(= temp0
					(AvoidPath
						(sel_42 sel_1:)
						(sel_42 sel_0:)
						sel_1
						sel_0
						(global95 sel_24:)
						temp3
						0
					)
				)
				(= temp1 (WordAt temp0 2))
				(= temp2 (WordAt temp0 3))
				(if (or (!= sel_1 temp1) (!= sel_0 temp2))
					(= sel_1 temp1)
					(= sel_0 temp2)
					(Memory memPOKE (+ sel_87 sel_74 2) 30583)
				)
				(Memory memFREE temp0)
			)
		)
	)
)
