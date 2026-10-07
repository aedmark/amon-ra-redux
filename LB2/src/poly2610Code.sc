;;; Sierra Script 1.0 - (do not remove this comment)
(script# 2610)
(include sci.sh)
(use Main)
(use MuseumPoints)
(use Polygon)
(use Obj)

(public
	poly2610Code 0
	pts2610 1
)

(local
	[theSel_87 66] = [0 0 319 0 319 189 157 189 164 170 316 170 316 157 316 144 311 155 302 154 297 157 263 158 244 157 202 130 197 122 185 122 185 103 178 103 178 122 169 122 127 153 117 158 93 159 64 155 66 145 99 132 78 132 24 147 2 157 57 175 65 178 65 189 0 189]
	[theSel_87_2 70] = [0 0 319 0 319 189 157 189 164 170 316 170 316 157 316 144 311 155 302 154 297 157 263 158 217 158 212 149 230 148 202 130 197 122 185 122 185 103 178 103 178 122 169 122 127 153 117 158 93 159 64 155 66 145 99 132 78 132 24 147 2 157 57 175 65 178 65 189 0 189]
)
(instance poly2610Code of Code
	(properties
		sel_20 {poly2610Code}
	)
	
	(method (sel_57 param1)
		(if (proc0_2 20)
			(param1 sel_118: (poly2610b sel_110: sel_117:))
		else
			(param1 sel_118: (poly2610 sel_110: sel_117:))
		)
	)
)

(instance poly2610 of Polygon
	(properties
		sel_20 {poly2610}
	)
	
	(method (sel_110)
		(= sel_31 2)
		(= sel_86 33)
		(= sel_87 @theSel_87)
	)
)

(instance poly2610b of Polygon
	(properties
		sel_20 {poly2610b}
	)
	
	(method (sel_110)
		(= sel_31 2)
		(= sel_86 35)
		(= sel_87 @theSel_87_2)
	)
)

(instance pts2610 of MuseumPoints
	(properties
		sel_20 {pts2610}
		sel_621 80
		sel_622 175
		sel_623 1180
		sel_624 125
		sel_625 80
		sel_626 250
		sel_627 1300
		sel_628 157
	)
)
