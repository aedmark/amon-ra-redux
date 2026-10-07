;;; Sierra Script 1.0 - (do not remove this comment)
(script# 2560)
(include sci.sh)
(use MuseumPoints)
(use Polygon)
(use Obj)

(public
	poly2560Code 0
	pts2560 1
)

(local
	[theSel_87 20] = [3 131 3 185 314 184 310 158 280 148 258 147 172 129 91 139 50 150 14 152]
	[theSel_87_2 8] = [42 160 59 172 27 179 13 170]
	[theSel_87_3 14] = [132 142 162 143 235 162 229 166 119 173 69 165 69 154]
	[theSel_87_4 10] = [264 150 256 156 224 156 172 142 173 140]
	[theSel_87_5 8] = [280 162 302 174 283 179 250 169]
)
(instance poly2560Code of Code
	(properties
		sel_20 {poly2560Code}
	)
	
	(method (sel_57 param1)
		(param1
			sel_118:
				(poly2560a sel_110: sel_117:)
				(poly2560b sel_110: sel_117:)
				(poly2560c sel_110: sel_117:)
				(poly2560d sel_110: sel_117:)
				(poly2560e sel_110: sel_117:)
		)
	)
)

(instance poly2560a of Polygon
	(properties
		sel_20 {poly2560a}
	)
	
	(method (sel_110)
		(= sel_31 3)
		(= sel_86 10)
		(= sel_87 @theSel_87)
	)
)

(instance poly2560b of Polygon
	(properties
		sel_20 {poly2560b}
	)
	
	(method (sel_110)
		(= sel_31 2)
		(= sel_86 4)
		(= sel_87 @theSel_87_2)
	)
)

(instance poly2560c of Polygon
	(properties
		sel_20 {poly2560c}
	)
	
	(method (sel_110)
		(= sel_31 2)
		(= sel_86 7)
		(= sel_87 @theSel_87_3)
	)
)

(instance poly2560d of Polygon
	(properties
		sel_20 {poly2560d}
	)
	
	(method (sel_110)
		(= sel_31 2)
		(= sel_86 5)
		(= sel_87 @theSel_87_4)
	)
)

(instance poly2560e of Polygon
	(properties
		sel_20 {poly2560e}
	)
	
	(method (sel_110)
		(= sel_31 2)
		(= sel_86 4)
		(= sel_87 @theSel_87_5)
	)
)

(instance pts2560 of MuseumPoints
	(properties
		sel_20 {pts2560}
		sel_621 160
		sel_622 165
		sel_629 1010
		sel_630 155
	)
)
