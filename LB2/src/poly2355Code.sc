;;; Sierra Script 1.0 - (do not remove this comment)
(script# 2355)
(include sci.sh)
(use MuseumPoints)
(use Polygon)
(use Obj)

(public
	poly2355Code 0
	pts2355 1
)

(local
	[theSel_87 44] = [0 156 38 156 66 136 6 136 6 125 69 125 69 134 87 120 231 120 304 136 304 157 319 157 319 179 278 179 255 161 240 161 233 154 94 154 90 161 70 161 44 179 0 179]
	[theSel_87_2 12] = [91 177 88 171 96 166 223 166 231 171 227 177]
	[theSel_87_3 16] = [0 0 319 0 319 99 281 99 281 66 256 66 256 97 0 97]
)
(instance poly2355Code of Code
	(properties
		sel_20 {poly2355Code}
	)
	
	(method (sel_57 param1)
		(param1
			sel_118:
				(poly2355a sel_110: sel_117:)
				(poly2355b sel_110: sel_117:)
				(poly2355c sel_110: sel_117:)
		)
	)
)

(instance poly2355a of Polygon
	(properties
		sel_20 {poly2355a}
	)
	
	(method (sel_110)
		(= sel_31 2)
		(= sel_86 22)
		(= sel_87 @theSel_87)
	)
)

(instance poly2355b of Polygon
	(properties
		sel_20 {poly2355b}
	)
	
	(method (sel_110)
		(= sel_31 2)
		(= sel_86 6)
		(= sel_87 @theSel_87_2)
	)
)

(instance poly2355c of Polygon
	(properties
		sel_20 {poly2355c}
	)
	
	(method (sel_110)
		(= sel_31 2)
		(= sel_86 8)
		(= sel_87 @theSel_87_3)
	)
)

(instance pts2355 of MuseumPoints
	(properties
		sel_20 {pts2355}
	)
)
