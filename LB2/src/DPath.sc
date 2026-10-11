;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 964)
(include sci.sh)
(use Motion)
(use System)

(class DPath of Motion
	(properties
		sel_20 {DPath}
		sel_87 0
		sel_74 0
	)

	(method (sel_110 param1 param2 &tmp temp0)
		(= sel_87
			(if sel_87
				sel_87
			else
				(List sel_109:)
			)
		)
		(if argc
			(= sel_42 param1)
			(for ((= temp0 0)) (<= temp0 (- argc 3)) ((++ temp0))
				(sel_87 sel_118: [param2 temp0] [param2 (++ temp0)])
			)
			(if (<= temp0 (- argc 2))
				(= sel_143 [param2 temp0])
			)
		)
		(if (sel_87 sel_122: -32768)
		else
			(sel_87 sel_118: -32768)
		)
		(self sel_251:)
		(super sel_110:)
		(if (not argc)
			(self sel_57:)
		)
	)

	(method (sel_111)
		(if (IsObject sel_87)
			(sel_87 sel_111:)
		)
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
