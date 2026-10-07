;;; Sierra Script 1.0 - (do not remove this comment)
(script# 2350)
(include sci.sh)
(use Main)
(use MuseumPoints)
(use Polygon)
(use Obj)

(public
	poly2350Code 0
	pts2350 1
)

(local
	[local0 32] = [0 156 38 156 87 120 231 120 304 157 319 157 319 179 278 179 255 161 240 161 233 154 94 154 90 161 70 161 44 179 0 179]
	[local32 44] = [0 156 38 156 66 136 6 136 6 125 69 125 69 134 87 120 231 120 304 136 304 157 319 157 319 179 278 179 255 161 240 161 233 154 94 154 90 161 70 161 44 179 0 179]
	[theSel_87_2 12] = [91 177 88 171 96 166 223 166 231 171 227 177]
	[theSel_87 20] = [91 177 88 171 96 166 223 166 231 171 227 177 210 177 202 185 133 185 125 177]
	[theSel_87_3 16] = [0 0 319 0 319 99 281 99 281 66 259 66 259 97 0 97]
)
(instance poly2350Code of Code
	(properties
		sel_20 {poly2350Code}
	)
	
	(method (sel_57 param1)
		(param1
			sel_118:
				(poly2350a sel_110: sel_117:)
				(poly2350b sel_110: sel_117:)
				(poly2350c sel_110: sel_117:)
		)
	)
)

(instance poly2350a of Polygon
	(properties
		sel_20 {poly2350a}
	)
	
	(method (sel_110)
		(= sel_86 (if (>= global123 (= sel_31 2)) 16 else 22))
		(= sel_87 (if (>= global123 2) @local0 else @local32))
	)
)

(instance poly2350b of Polygon
	(properties
		sel_20 {poly2350b}
	)
	
	(method (sel_110)
		(= sel_31 2)
		(if (proc999_5 global128 0 1 4 5 9 13)
			(= sel_86 10)
			(= sel_87 @theSel_87)
		else
			(= sel_86 6)
			(= sel_87 @theSel_87_2)
		)
	)
)

(instance poly2350c of Polygon
	(properties
		sel_20 {poly2350c}
	)
	
	(method (sel_110)
		(= sel_31 2)
		(= sel_86 8)
		(= sel_87 @theSel_87_3)
	)
)

(instance pts2350 of MuseumPoints
	(properties
		sel_20 {pts2350}
		sel_621 275
		sel_622 120
		sel_623 264
		sel_624 86
		sel_627 330
		sel_628 120
		sel_629 -10
		sel_630 120
	)
)
