;;; Sierra Script 1.0 - (do not remove this comment)
(script# 2400)
(include sci.sh)
(use MuseumPoints)
(use Polygon)
(use Obj)

(public
	poly2400Code 0
	pts2400 1
)

(local
	[theSel_87 18] = [0 163 0 0 319 0 319 189 299 167 283 167 225 109 91 109 37 163]
	[theSel_87_2 8] = [186 123 233 123 267 163 207 163]
)
(instance poly2400Code of Code
	(properties
		sel_20 {poly2400Code}
	)
	
	(method (sel_57 param1)
		(param1
			sel_118: (poly2400a sel_110: sel_117:) (poly2400b sel_110: sel_117:)
		)
	)
)

(instance poly2400a of Polygon
	(properties
		sel_20 {poly2400a}
	)
	
	(method (sel_110)
		(= sel_31 2)
		(= sel_86 9)
		(= sel_87 @theSel_87)
	)
)

(instance poly2400b of Polygon
	(properties
		sel_20 {poly2400b}
	)
	
	(method (sel_110)
		(= sel_31 2)
		(= sel_86 4)
		(= sel_87 @theSel_87_2)
	)
)

(instance pts2400 of MuseumPoints
	(properties
		sel_20 {pts2400}
	)
)
