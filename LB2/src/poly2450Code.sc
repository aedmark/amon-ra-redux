;;; Sierra Script 1.0 - (do not remove this comment)
(script# 2450)
(include sci.sh)
(use MuseumPoints)
(use Polygon)
(use Obj)

(public
	poly2450Code 0
	pts2450 1
)

(local
	[theSel_87 16] = [0 0 319 0 319 189 314 189 314 141 272 125 224 120 0 120]
	[theSel_87_2 8] = [18 124 137 124 137 144 18 144]
	[theSel_87_3 8] = [7 150 61 150 61 177 7 177]
	[theSel_87_4 8] = [94 147 153 147 153 180 94 180]
	[theSel_87_5 8] = [202 136 239 136 239 153 202 153]
)
(instance poly2450Code of Code
	(properties
		sel_20 {poly2450Code}
	)
	
	(method (sel_57 param1)
		(param1
			sel_118:
				(poly2450a sel_110: sel_117:)
				(poly2450b sel_110: sel_117:)
				(poly2450c sel_110: sel_117:)
				(poly2450d sel_110: sel_117:)
				(poly2450e sel_110: sel_117:)
		)
	)
)

(instance poly2450a of Polygon
	(properties
		sel_20 {poly2450a}
	)
	
	(method (sel_110)
		(= sel_31 2)
		(= sel_86 8)
		(= sel_87 @theSel_87)
	)
)

(instance poly2450b of Polygon
	(properties
		sel_20 {poly2450b}
	)
	
	(method (sel_110)
		(= sel_31 2)
		(= sel_86 4)
		(= sel_87 @theSel_87_2)
	)
)

(instance poly2450c of Polygon
	(properties
		sel_20 {poly2450c}
	)
	
	(method (sel_110)
		(= sel_31 2)
		(= sel_86 4)
		(= sel_87 @theSel_87_3)
	)
)

(instance poly2450d of Polygon
	(properties
		sel_20 {poly2450d}
	)
	
	(method (sel_110)
		(= sel_31 2)
		(= sel_86 4)
		(= sel_87 @theSel_87_4)
	)
)

(instance poly2450e of Polygon
	(properties
		sel_20 {poly2450e}
	)
	
	(method (sel_110)
		(= sel_31 2)
		(= sel_86 4)
		(= sel_87 @theSel_87_5)
	)
)

(instance pts2450 of MuseumPoints
	(properties
		sel_20 {pts2450}
		sel_621 200
		sel_622 160
		sel_625 200
		sel_626 250
		sel_629 -10
		sel_630 175
	)
)
