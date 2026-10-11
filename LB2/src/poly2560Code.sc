;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2560)
(include sci.sh)
(use MuseumPoints)
(use Polygon)
(use System)

(public
	poly2560Code 0
	pts2560 1
)

(local
	[local0 20] = [3 131 3 185 314 184 310 158 280 148 258 147 172 129 91 139 50 150 14 152]
	[local20 8] = [42 160 59 172 27 179 13 170]
	[local28 14] = [132 142 162 143 235 162 229 166 119 173 69 165 69 154]
	[local42 10] = [264 150 256 156 224 156 172 142 173 140]
	[local52 8] = [280 162 302 174 283 179 250 169]
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
		(= sel_87 @local0)
	)
)

(instance poly2560b of Polygon
	(properties
		sel_20 {poly2560b}
	)

	(method (sel_110)
		(= sel_31 2)
		(= sel_86 4)
		(= sel_87 @local20)
	)
)

(instance poly2560c of Polygon
	(properties
		sel_20 {poly2560c}
	)

	(method (sel_110)
		(= sel_31 2)
		(= sel_86 7)
		(= sel_87 @local28)
	)
)

(instance poly2560d of Polygon
	(properties
		sel_20 {poly2560d}
	)

	(method (sel_110)
		(= sel_31 2)
		(= sel_86 5)
		(= sel_87 @local42)
	)
)

(instance poly2560e of Polygon
	(properties
		sel_20 {poly2560e}
	)

	(method (sel_110)
		(= sel_31 2)
		(= sel_86 4)
		(= sel_87 @local52)
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
