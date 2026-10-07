;;; Sierra Script 1.0 - (do not remove this comment)
(script# 2460)
(include sci.sh)
(use MuseumPoints)
(use Polygon)
(use Obj)

(public
	poly2460Code 0
	pts2460 1
)

(local
	[theSel_87 26] = [0 0 319 0 319 162 284 150 265 140 186 139 151 145 111 143 97 89 90 145 78 146 72 169 0 168]
	[theSel_87_2 8] = [192 144 222 144 222 155 193 155]
)
(instance poly2460Code of Code
	(properties
		sel_20 {poly2460Code}
	)
	
	(method (sel_57 param1)
		(param1
			sel_118: (poly2460a sel_110: sel_117:) (poly2460b sel_110: sel_117:)
		)
	)
)

(instance poly2460a of Polygon
	(properties
		sel_20 {poly2460a}
	)
	
	(method (sel_110)
		(= sel_31 2)
		(= sel_86 13)
		(= sel_87 @theSel_87)
	)
)

(instance poly2460b of Polygon
	(properties
		sel_20 {poly2460b}
	)
	
	(method (sel_110)
		(= sel_31 2)
		(= sel_86 4)
		(= sel_87 @theSel_87_2)
	)
)

(instance pts2460 of MuseumPoints
	(properties
		sel_20 {pts2460}
	)
)
