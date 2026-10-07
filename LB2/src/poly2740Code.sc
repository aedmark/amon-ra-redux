;;; Sierra Script 1.0 - (do not remove this comment)
(script# 2740)
(include sci.sh)
(use Polygon)
(use Obj)

(public
	poly2740Code 0
	proc2740_1 1
)

(local
	[theSel_87 32] = [36 189 0 189 0 0 319 0 319 189 48 189 192 106 294 106 294 37 272 37 272 104 248 104 248 37 220 37 220 104 184 104]
)
(procedure (proc2740_1)
)

(instance poly2740Code of Code
	(properties
		sel_20 {poly2740Code}
	)
	
	(method (sel_57 param1)
		(param1 sel_118: (poly2740a sel_110: sel_117:))
	)
)

(instance poly2740a of Polygon
	(properties
		sel_20 {poly2740a}
	)
	
	(method (sel_110)
		(= sel_31 2)
		(= sel_86 16)
		(= sel_87 @theSel_87)
	)
)
