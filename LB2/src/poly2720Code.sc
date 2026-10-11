;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2720)
(include sci.sh)
(use Main)
(use Polygon)
(use System)

(public
	poly2720Code 0
	proc2720_1 1
)

(local
	[local0 30] = [3 173 30 173 54 187 315 186 315 167 303 172 235 159 253 142 207 140 189 153 154 161 99 161 43 148 30 142 4 148]
	[local30 38] = [3 173 30 173 54 187 315 186 315 167 303 172 294 181 253 185 252 176 267 166 235 159 253 142 207 140 189 153 154 161 99 161 43 148 30 142 4 148]
	[local68 36] = [3 173 30 173 54 187 315 186 309 174 283 172 273 180 245 172 250 164 235 160 253 142 207 140 189 153 154 161 99 161 43 148 30 142 4 148]
)

(procedure (proc2720_1)) ; UNUSED

(instance poly2720Code of Code
	(properties
		sel_20 {poly2720Code}
	)

	(method (sel_57 param1)
		(cond
			((IsFlag 65)
				(param1 sel_118: (poly2720b sel_110: sel_117:))
			)
			((IsFlag 121)
				(param1 sel_118: (poly2720c sel_110: sel_117:))
			)
			(else
				(param1 sel_118: (poly2720a sel_110: sel_117:))
			)
		)
	)
)

(instance poly2720a of Polygon
	(properties
		sel_20 {poly2720a}
	)

	(method (sel_110)
		(= sel_31 3)
		(= sel_86 15)
		(= sel_87 @local0)
	)
)

(instance poly2720b of Polygon
	(properties
		sel_20 {poly2720b}
	)

	(method (sel_110)
		(= sel_31 3)
		(= sel_86 19)
		(= sel_87 @local30)
	)
)

(instance poly2720c of Polygon
	(properties
		sel_20 {poly2720c}
	)

	(method (sel_110)
		(= sel_31 3)
		(= sel_86 18)
		(= sel_87 @local68)
	)
)
