;;; Sierra Script 1.0 - (do not remove this comment)
(script# 2640)
(include sci.sh)
(use MuseumPoints)
(use Polygon)
(use Obj)

(public
	poly2640Code 0
	pts2640 1
)

(local
	[theSel_87 46] = [213 138 121 138 106 147 47 147 38 147 6 129 2 140 29 153 32 157 36 161 16 173 4 173 4 183 23 183 23 189 165 189 210 165 279 185 293 175 260 160 231 159 226 153 228 146]
)
(instance poly2640Code of Code
	(properties
		sel_20 {poly2640Code}
	)
	
	(method (sel_57 param1)
		(param1 sel_118: (poly2640 sel_110: sel_117:))
	)
)

(instance poly2640 of Polygon
	(properties
		sel_20 {poly2640}
	)
	
	(method (sel_110)
		(= sel_31 3)
		(= sel_86 23)
		(= sel_87 @theSel_87)
	)
)

(instance pts2640 of MuseumPoints
	(properties
		sel_20 {pts2640}
		sel_621 145
		sel_622 155
		sel_629 1045
		sel_630 150
	)
)
