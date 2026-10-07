;;; Sierra Script 1.0 - (do not remove this comment)
(script# 2335)
(include sci.sh)
(use Main)
(use MuseumPoints)
(use Polygon)
(use Obj)

(public
	poly2335Code 0
	pts2335 1
)

(local
	[theSel_87 28] = [85 179 85 189 0 189 0 0 319 0 319 189 284 189 284 158 178 170 161 167 161 134 150 134 150 168 143 179]
	[theSel_87_2 26] = [85 179 85 189 0 189 0 0 319 0 319 189 284 189 284 158 178 170 161 167 161 134 150 134 150 168]
)
(instance poly2335Code of Code
	(properties
		sel_20 {poly2335Code}
	)
	
	(method (sel_57 param1)
		(if (and (== global123 2) (not (proc0_2 25)))
			(param1 sel_118: (poly2335a sel_110: sel_117:))
		else
			(param1 sel_118: (poly2335b sel_110: sel_117:))
		)
	)
)

(instance poly2335a of Polygon
	(properties
		sel_20 {poly2335a}
	)
	
	(method (sel_110)
		(= sel_31 2)
		(= sel_86 14)
		(= sel_87 @theSel_87)
	)
)

(instance poly2335b of Polygon
	(properties
		sel_20 {poly2335b}
	)
	
	(method (sel_110)
		(= sel_31 2)
		(= sel_86 13)
		(= sel_87 @theSel_87_2)
	)
)

(instance pts2335 of MuseumPoints
	(properties
		sel_20 {pts2335}
	)
)
