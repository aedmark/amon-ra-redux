;;; Sierra Script 1.0 - (do not remove this comment)
(script# 2530)
(include sci.sh)
(use Main)
(use MuseumPoints)
(use Polygon)
(use Obj)

(public
	poly2530Code 0
	pts2530 1
)

(local
	[local0 8] = [60 152 0 182 0 13 55 72]
	[local8 20] = [68 130 245 130 257 161 251 171 210 185 165 185 118 185 95 180 71 170 66 160]
	[theSel_87 8] = [267 95 319 12 319 176 264 151]
	[local36 54] = [91 143 74 146 46 155 12 166 0 189 0 3 319 3 319 189 311 169 292 160 274 155 246 145 227 141 227 155 262 159 263 170 208 179 203 163 194 149 106 149 102 161 123 166 119 177 108 178 56 168 68 157 90 158]
	[local90 28] = [114 144 104 145 103 137 126 134 146 133 175 135 201 140 223 146 220 151 195 141 171 137 150 136 132 136 118 139]
)
(instance poly2530Code of Code
	(properties
		sel_20 {poly2530Code}
	)
	
	(method (sel_57 param1)
		(param1
			sel_118: (poly2530a sel_110: sel_117:) (poly2530b sel_110: sel_117:)
		)
		(if (not (proc0_2 31))
			(param1 sel_118: (poly2530c sel_110: sel_117:))
		)
	)
)

(instance poly2530a of Polygon
	(properties
		sel_20 {poly2530a}
	)
	
	(method (sel_110)
		(= sel_31 2)
		(= sel_86 (if (proc0_2 31) 27 else 4))
		(= sel_87 (if (proc0_2 31) @local36 else @local0))
	)
)

(instance poly2530b of Polygon
	(properties
		sel_20 {poly2530b}
	)
	
	(method (sel_110)
		(= sel_31 2)
		(= sel_86 (if (proc0_2 31) 14 else 10))
		(= sel_87 (if (proc0_2 31) @local90 else @local8))
	)
)

(instance poly2530c of Polygon
	(properties
		sel_20 {poly2530c}
	)
	
	(method (sel_110)
		(= sel_31 2)
		(= sel_86 4)
		(= sel_87 @theSel_87)
	)
)

(instance pts2530 of MuseumPoints
	(properties
		sel_20 {pts2530}
		sel_621 290
		sel_622 175
		sel_623 100
		sel_624 160
		sel_625 230
		sel_626 150
	)
)
