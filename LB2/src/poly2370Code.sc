;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2370)
(include sci.sh)
(use Main)
(use MuseumPoints)
(use Polygon)
(use System)

(public
	poly2370Code 0
	pts2370 1
)

(local
	[local0 42] = [0 0 319 0 319 189 291 189 311 185 256 148 306 148 306 144 250 144 221 132 209 132 182 121 154 121 140 117 139 112 120 105 94 102 50 98 0 98 -100 179 -100 165]
	[local42 44] = [0 0 319 0 319 189 291 189 311 185 264 149 309 149 309 144 258 144 243 137 230 137 219 129 186 136 167 136 160 133 154 121 140 117 140 109 100 109 94 101 50 98 0 98]
	[local86 12] = [-100 179 -100 165 78 165 88 171 83 183 68 179]
	[local98 10] = [202 162 244 162 264 168 272 181 229 181]
	[local108 8] = [137 175 185 175 185 189 137 189]
)

(instance poly2370Code of Code
	(properties
		sel_20 {poly2370Code}
	)

	(method (sel_57 param1)
		(param1
			sel_118:
				(poly2370a sel_110: sel_117:)
				(poly2370b sel_110: sel_117:)
				(if (== gAct 2)
					(poly2370c sel_110: sel_117:)
				else
					0
				)
				(if (OneOf global128 6 7 8)
					(poly2370d sel_110: sel_117:)
				else
					0
				)
		)
	)
)

(instance poly2370a of Polygon
	(properties
		sel_20 {poly2370a}
	)

	(method (sel_110)
		(= sel_86 (if (> gAct (= sel_31 2)) 21 else 22))
		(= sel_87 (if (> gAct 2) @local0 else @local42))
	)
)

(instance poly2370b of Polygon
	(properties
		sel_20 {poly2370b}
	)

	(method (sel_110)
		(= sel_31 2)
		(= sel_86 6)
		(= sel_87 @local86)
	)
)

(instance poly2370c of Polygon
	(properties
		sel_20 {poly2370c}
	)

	(method (sel_110)
		(= sel_31 2)
		(= sel_86 5)
		(= sel_87 @local98)
	)
)

(instance poly2370d of Polygon
	(properties
		sel_20 {poly2370d}
	)

	(method (sel_110)
		(= sel_31 2)
		(= sel_86 4)
		(= sel_87 @local108)
	)
)

(instance pts2370 of MuseumPoints
	(properties
		sel_20 {pts2370}
		sel_621 110
		sel_622 130
		sel_629 -10
		sel_630 120
	)
)
