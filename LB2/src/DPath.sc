;;; Sierra Script 1.0 - (do not remove this comment)
(script# 964)
(include sci.sh)
(use Cycle)
(use Obj)


(class DPath of Motion
	(properties
		sel_20 {DPath}
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
		sel_87 0
		sel_74 0
	)
	
	(method (sel_110 theSel_42 theSel_143 &tmp temp0)
		(= sel_87 (if sel_87 else (List sel_109:)))
		(if argc
			(= sel_42 theSel_42)
			(= temp0 0)
			(while (<= temp0 (- argc 3))
				(sel_87
					sel_118: [theSel_143 temp0] [theSel_143 (++ temp0)]
				)
				(++ temp0)
			)
			(if (<= temp0 (- argc 2))
				(= sel_143 [theSel_143 temp0])
			)
		)
		(if (sel_87 sel_122: -32768)
		else
			(sel_87 sel_118: -32768)
		)
		(self sel_251:)
		(super sel_110:)
		(if (not argc) (self sel_57:))
	)
	
	(method (sel_111)
		(if (IsObject sel_87) (sel_87 sel_111:))
		(super sel_111:)
	)
	
	(method (sel_97)
		(if (== (sel_87 sel_64: sel_74) -32768)
			(super sel_97:)
		else
			(self sel_110:)
		)
	)
	
	(method (sel_251)
		(if (!= (sel_87 sel_64: sel_74) -32768)
			(= sel_1 (sel_87 sel_64: sel_74))
			(= sel_0 (sel_87 sel_64: (++ sel_74)))
			(++ sel_74)
		)
	)
)
