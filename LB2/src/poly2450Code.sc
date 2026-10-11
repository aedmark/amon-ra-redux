;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2450)
(include sci.sh)
(use MuseumPoints)
(use Polygon)
(use System)

(public
	poly2450Code 0
	pts2450 1
)

(local
	[local0 16] = [0 0 319 0 319 189 314 189 314 141 272 125 224 120 0 120]
	[local16 8] = [18 124 137 124 137 144 18 144]
	[local24 8] = [7 150 61 150 61 177 7 177]
	[local32 8] = [94 147 153 147 153 180 94 180]
	[local40 8] = [202 136 239 136 239 153 202 153]
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
		(= sel_87 @local0)
	)
)

(instance poly2450b of Polygon
	(properties
		sel_20 {poly2450b}
	)

	(method (sel_110)
		(= sel_31 2)
		(= sel_86 4)
		(= sel_87 @local16)
	)
)

(instance poly2450c of Polygon
	(properties
		sel_20 {poly2450c}
	)

	(method (sel_110)
		(= sel_31 2)
		(= sel_86 4)
		(= sel_87 @local24)
	)
)

(instance poly2450d of Polygon
	(properties
		sel_20 {poly2450d}
	)

	(method (sel_110)
		(= sel_31 2)
		(= sel_86 4)
		(= sel_87 @local32)
	)
)

(instance poly2450e of Polygon
	(properties
		sel_20 {poly2450e}
	)

	(method (sel_110)
		(= sel_31 2)
		(= sel_86 4)
		(= sel_87 @local40)
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
