;;; Sierra Script 1.0 - (do not remove this comment)
(script# 2630)
(include sci.sh)
(use Main)
(use MuseumPoints)
(use Polygon)
(use Obj)

(public
	poly2630Code 0
	pts2630 1
)

(local
	[theSel_87 42] = [98 141 90 144 69 144 46 154 0 154 0 189 311 189 311 151 298 151 257 143 265 139 298 139 297 132 268 132 259 141 231 141 220 145 169 145 159 143 115 143 109 141]
	[theSel_87_2 42] = [98 141 90 144 69 144 46 154 0 154 0 189 311 189 311 151 298 151 258 143 265 139 298 139 297 132 268 132 259 141 231 141 220 145 169 145 159 143 115 143 109 141]
)
(instance poly2630Code of Code
	(properties
		sel_20 {poly2630Code}
	)
	
	(method (sel_57 param1)
		(if (proc0_2 12)
			(param1 sel_118: (poly2630b sel_110: sel_117:))
		else
			(param1 sel_118: (poly2630a sel_110: sel_117:))
		)
	)
)

(instance poly2630a of Polygon
	(properties
		sel_20 {poly2630a}
	)
	
	(method (sel_110)
		(= sel_31 3)
		(= sel_86 21)
		(= sel_87 @theSel_87)
	)
)

(instance poly2630b of Polygon
	(properties
		sel_20 {poly2630b}
	)
	
	(method (sel_110)
		(= sel_31 3)
		(= sel_86 21)
		(= sel_87 @theSel_87_2)
	)
)

(instance pts2630 of MuseumPoints
	(properties
		sel_20 {pts2630}
		sel_621 230
		sel_622 155
		sel_627 1255
		sel_628 143
	)
)
