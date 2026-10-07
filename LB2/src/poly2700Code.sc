;;; Sierra Script 1.0 - (do not remove this comment)
(script# 2700)
(include sci.sh)
(use Polygon)
(use Obj)

(public
	poly2700Code 0
	proc2700_1 1
)

(local
	[theSel_87 20] = [99 148 175 148 182 144 176 134 179 127 173 119 156 119 156 125 131 125 131 136]
)
(procedure (proc2700_1)
)

(instance poly2700Code of Code
	(properties
		sel_20 {poly2700Code}
	)
	
	(method (sel_57 param1)
		(param1 sel_118: (poly2700a sel_110: sel_117:))
	)
)

(instance poly2700a of Polygon
	(properties
		sel_20 {poly2700a}
	)
	
	(method (sel_110)
		(= sel_31 3)
		(= sel_86 10)
		(= sel_87 @theSel_87)
	)
)
