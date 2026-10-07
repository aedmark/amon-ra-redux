;;; Sierra Script 1.0 - (do not remove this comment)
(script# 2500)
(include sci.sh)
(use MuseumPoints)
(use Polygon)
(use Obj)

(public
	poly2500Code 0
	pts2500 1
)

(local
	[theSel_87 32] = [97 136 92 165 31 165 27 170 52 170 40 189 0 189 0 0 319 0 319 189 269 181 247 184 217 177 217 172 168 164 108 163]
	[theSel_87_2 8] = [149 174 160 181 132 181 122 174]
	[theSel_87_3 8] = [126 165 131 170 106 170 102 165]
)
(instance poly2500Code of Code
	(properties
		sel_20 {poly2500Code}
	)
	
	(method (sel_57 param1)
		(param1
			sel_118:
				(poly2500a sel_110: sel_117:)
				(poly2500c sel_110: sel_117:)
				(poly2500d sel_110: sel_117:)
		)
	)
)

(instance poly2500a of Polygon
	(properties
		sel_20 {poly2500a}
	)
	
	(method (sel_110)
		(= sel_31 2)
		(= sel_86 16)
		(= sel_87 @theSel_87)
	)
)

(instance poly2500c of Polygon
	(properties
		sel_20 {poly2500c}
	)
	
	(method (sel_110)
		(= sel_31 2)
		(= sel_86 4)
		(= sel_87 @theSel_87_2)
	)
)

(instance poly2500d of Polygon
	(properties
		sel_20 {poly2500d}
	)
	
	(method (sel_110)
		(= sel_31 2)
		(= sel_86 4)
		(= sel_87 @theSel_87_3)
	)
)

(instance pts2500 of MuseumPoints
	(properties
		sel_20 {pts2500}
		sel_621 170
		sel_622 175
		sel_623 97
		sel_624 150
		sel_625 170
		sel_626 250
	)
)
