;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 930)
(include sci.sh)
(use Main)
(use PolyPath)
(use System)

(class PChase of PolyPath
	(properties
		sel_20 {PChase}
		sel_36 0
		sel_254 0
		sel_272 0
		sel_273 0
	)

	(method (sel_110 param1 param2 param3 param4 param5)
		(cond
			((>= argc 5)
				(= sel_259 param5)
			)
			((not (IsObject sel_259))
				(= sel_259 (gCurRoom sel_259:))
			)
		)
		(if (>= argc 1)
			(= sel_42 param1)
			(if (>= argc 2)
				(= sel_36 param2)
				(= sel_272 (sel_36 sel_1:))
				(= sel_273 (sel_36 sel_0:))
				(if (>= argc 3)
					(= sel_254 param3)
					(if (>= argc 4)
						(= sel_143 param4)
					)
				)
			)
		)
		(super sel_110: sel_42 sel_272 sel_273 sel_143 1 sel_259)
	)

	(method (sel_57 &tmp temp0)
		(cond
			(
				(>
					(GetDistance
						sel_272
						sel_273
						(sel_36 sel_1:)
						(sel_36 sel_0:)
					)
					sel_254
				)
				(if sel_87
					(Memory memFREE sel_87)
				)
				(= sel_87 0)
				(= sel_74 2)
				(self sel_110: sel_42 sel_36)
			)
			((<= (= temp0 (sel_42 sel_255: sel_36)) sel_254)
				(self sel_97:)
			)
			(else
				(super sel_57:)
			)
		)
	)

	(method (sel_97 &tmp temp0)
		(cond
			((<= (= temp0 (sel_42 sel_255: sel_36)) sel_254)
				(super sel_97:)
			)
			((== (WordAt sel_87 sel_74) 30583)
				(if sel_87
					(Memory memFREE sel_87)
				)
				(= sel_87 0)
				(= sel_74 2)
				(self sel_110: sel_42 sel_36)
			)
			(else
				(self sel_110:)
			)
		)
	)
)

(class PFollow of PolyPath
	(properties
		sel_20 {PFollow}
		sel_36 0
		sel_254 0
		sel_272 0
		sel_273 0
	)

	(method (sel_110 param1 param2 param3 param4 &tmp temp0)
		(= temp0
			(if (>= argc 4)
				param4
			else
				(gCurRoom sel_259:)
			)
		)
		(if (>= argc 1)
			(= sel_42 param1)
			(if (>= argc 2)
				(= sel_36 param2)
				(= sel_272 (sel_36 sel_1:))
				(= sel_273 (sel_36 sel_0:))
				(if (>= argc 3)
					(= sel_254 param3)
				)
			)
		)
		(super sel_110: sel_42 sel_272 sel_273 0 1 temp0)
	)

	(method (sel_57 &tmp temp0 temp1)
		(cond
			(
				(>
					(GetDistance
						sel_272
						sel_273
						(sel_36 sel_1:)
						(sel_36 sel_0:)
					)
					sel_254
				)
				(if sel_87
					(Memory memFREE sel_87)
				)
				(= sel_87 0)
				(= sel_74 2)
				(self sel_110: sel_42 sel_36)
				0
			)
			((<= (= temp0 (sel_42 sel_255: sel_36)) sel_254)
				(= temp1
					(GetAngle
						(sel_42 sel_1:)
						(sel_42 sel_0:)
						(sel_36 sel_1:)
						(sel_36 sel_0:)
					)
				)
				(if (!= (sel_42 sel_55:) temp1)
					(sel_42 sel_253: temp1)
				)
				(= sel_249 (sel_42 sel_1:))
				(= sel_250 (sel_42 sel_0:))
				(= sel_45 gGameTime)
				0
			)
			(else
				(super sel_57:)
			)
		)
	)

	(method (sel_97)
		(self sel_110:)
	)
)
