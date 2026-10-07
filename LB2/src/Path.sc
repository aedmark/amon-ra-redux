;;; Sierra Script 1.0 - (do not remove this comment)
(script# 983)
(include sci.sh)
(use Print)
(use Cycle)


(class Path of MoveTo
	(properties
		sel_20 {Path}
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
		sel_446 0
		sel_74 0
	)
	
	(method (sel_110 theSel_42 param2 param3)
		(= sel_42 theSel_42)
		(= sel_143 (if (>= argc 2) param2 else 0))
		(= sel_446 (if (== argc 3) param3 else 0))
		(= sel_74 -1)
		(= sel_1 (sel_42 sel_1?))
		(= sel_0 (sel_42 sel_0?))
		(if (self sel_447:)
			(self sel_97:)
		else
			(self sel_65:)
			(super sel_110: sel_42 sel_1 sel_0)
		)
	)
	
	(method (sel_97)
		(if (self sel_447:)
			(super sel_97:)
		else
			(if sel_446 (sel_446 sel_145: (/ sel_74 2)))
			(self sel_65:)
			(super sel_110: sel_42 sel_1 sel_0)
		)
	)
	
	(method (sel_64 &tmp [temp0 20])
		(Print
			sel_199: @temp0 {%s needs an 'at:' method.} sel_20
			sel_110:
		)
		(return 0)
	)
	
	(method (sel_65)
		(= sel_1 (self sel_64: (++ sel_74)))
		(= sel_0 (self sel_64: (++ sel_74)))
	)
	
	(method (sel_447)
		(return
			(if (== (self sel_64: (+ sel_74 1)) -32768)
			else
				(== (self sel_64: (+ sel_74 2)) -32768)
			)
		)
	)
)

(class RelPath of Path
	(properties
		sel_20 {RelPath}
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
		sel_446 0
		sel_74 0
	)
	
	(method (sel_65)
		(= sel_1 (+ sel_1 (self sel_64: (++ sel_74))))
		(= sel_0 (+ sel_0 (self sel_64: (++ sel_74))))
	)
)
