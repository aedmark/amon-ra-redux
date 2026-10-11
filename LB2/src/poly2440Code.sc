;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2440)
(include sci.sh)
(use MuseumPoints)
(use Polygon)
(use System)

(public
	poly2440Code 0
	pts2440 1
)

(local
	[local0 34] = [0 0 319 0 319 170 264 163 254 156 209 148 215 140 264 124 242 127 216 137 200 144 172 140 139 96 100 139 76 146 6 147 0 189]
	[local34 8] = [29 177 102 167 102 182 34 188]
	[local42 8] = [111 145 134 145 133 153 112 152]
	[local50 8] = [131 158 175 158 175 167 126 166]
	[local58 8] = [201 189 210 182 263 184 274 189]
)

(instance poly2440Code of Code
	(properties
		sel_20 {poly2440Code}
	)

	(method (sel_57 param1)
		(param1
			sel_118:
				(poly2440a sel_110: sel_117:)
				(poly2440b sel_110: sel_117:)
				(poly2440c sel_110: sel_117:)
				(poly2440d sel_110: sel_117:)
				(poly2440e sel_110: sel_117:)
		)
	)
)

(instance poly2440a of Polygon
	(properties
		sel_20 {poly2440a}
	)

	(method (sel_110)
		(= sel_31 2)
		(= sel_86 17)
		(= sel_87 @local0)
	)
)

(instance poly2440b of Polygon
	(properties
		sel_20 {poly2440b}
	)

	(method (sel_110)
		(= sel_31 2)
		(= sel_86 4)
		(= sel_87 @local34)
	)
)

(instance poly2440c of Polygon
	(properties
		sel_20 {poly2440c}
	)

	(method (sel_110)
		(= sel_31 2)
		(= sel_86 4)
		(= sel_87 @local42)
	)
)

(instance poly2440d of Polygon
	(properties
		sel_20 {poly2440d}
	)

	(method (sel_110)
		(= sel_31 2)
		(= sel_86 4)
		(= sel_87 @local50)
	)
)

(instance poly2440e of Polygon
	(properties
		sel_20 {poly2440e}
	)

	(method (sel_110)
		(= sel_31 2)
		(= sel_86 4)
		(= sel_87 @local58)
	)
)

(instance pts2440 of MuseumPoints
	(properties
		sel_20 {pts2440}
		sel_621 180
		sel_622 150
		sel_623 135
		sel_624 130
		sel_625 110
		sel_626 250
		sel_627 235
		sel_628 140
	)
)
