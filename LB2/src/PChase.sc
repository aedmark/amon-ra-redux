;;; Sierra Script 1.0 - (do not remove this comment)
(script# 930)
(include sci.sh)
(use Main)
(use PolyPath)
(use Obj)


(class PChase of PolyPath
	(properties
		sel_20 {PChase}
		sel_42 0
		sel_143 0
		sel_1 0
		sel_0 0
		sel_43 0
		sel_44 0
		sel_45 0
		sel_46 0
		sel_47 0
		sel_48 0
		sel_49 0
		sel_50 0
		sel_240 0
		sel_249 0
		sel_250 0
		sel_74 2
		sel_87 0
		sel_257 0
		sel_258 0
		sel_259 0
		sel_36 0
		sel_254 0
		sel_272 0
		sel_273 0
	)
	
	(method (sel_110 theSel_42 theSel_36 theSel_254 theSel_143 theSel_259)
		(cond 
			((>= argc 5) (= sel_259 theSel_259))
			((not (IsObject sel_259)) (= sel_259 (global2 sel_259?)))
		)
		(if (>= argc 1)
			(= sel_42 theSel_42)
			(if (>= argc 2)
				(= sel_36 theSel_36)
				(= sel_272 (sel_36 sel_1?))
				(= sel_273 (sel_36 sel_0?))
				(if (>= argc 3)
					(= sel_254 theSel_254)
					(if (>= argc 4) (= sel_143 theSel_143))
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
						(sel_36 sel_1?)
						(sel_36 sel_0?)
					)
					sel_254
				)
				(if sel_87 (Memory memFREE sel_87))
				(= sel_87 0)
				(= sel_74 2)
				(self sel_110: sel_42 sel_36)
			)
			(
			(<= (= temp0 (sel_42 sel_255: sel_36)) sel_254) (self sel_97:))
			(else (super sel_57:))
		)
	)
	
	(method (sel_97 &tmp temp0)
		(cond 
			(
			(<= (= temp0 (sel_42 sel_255: sel_36)) sel_254) (super sel_97:))
			((== (proc999_6 sel_87 sel_74) 30583)
				(if sel_87 (Memory memFREE sel_87))
				(= sel_87 0)
				(= sel_74 2)
				(self sel_110: sel_42 sel_36)
			)
			(else (self sel_110:))
		)
	)
)

(class PFollow of PolyPath
	(properties
		sel_20 {PFollow}
		sel_42 0
		sel_143 0
		sel_1 0
		sel_0 0
		sel_43 0
		sel_44 0
		sel_45 0
		sel_46 0
		sel_47 0
		sel_48 0
		sel_49 0
		sel_50 0
		sel_240 0
		sel_249 0
		sel_250 0
		sel_74 2
		sel_87 0
		sel_257 0
		sel_258 0
		sel_259 0
		sel_36 0
		sel_254 0
		sel_272 0
		sel_273 0
	)
	
	(method (sel_110 theSel_42 theSel_36 theSel_254 param4 &tmp temp0)
		(= temp0
			(if (>= argc 4) param4 else (global2 sel_259?))
		)
		(if (>= argc 1)
			(= sel_42 theSel_42)
			(if (>= argc 2)
				(= sel_36 theSel_36)
				(= sel_272 (sel_36 sel_1?))
				(= sel_273 (sel_36 sel_0?))
				(if (>= argc 3) (= sel_254 theSel_254))
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
						(sel_36 sel_1?)
						(sel_36 sel_0?)
					)
					sel_254
				)
				(if sel_87 (Memory memFREE sel_87))
				(= sel_87 0)
				(= sel_74 2)
				(self sel_110: sel_42 sel_36)
				0
			)
			(
			(<= (= temp0 (sel_42 sel_255: sel_36)) sel_254)
				(= temp1
					(GetAngle
						(sel_42 sel_1?)
						(sel_42 sel_0?)
						(sel_36 sel_1?)
						(sel_36 sel_0?)
					)
				)
				(if (!= (sel_42 sel_55?) temp1)
					(sel_42 sel_253: temp1)
				)
				(= sel_249 (sel_42 sel_1?))
				(= sel_250 (sel_42 sel_0?))
				(= sel_45 gSel_45)
				0
			)
			(else (super sel_57:))
		)
	)
	
	(method (sel_97)
		(self sel_110:)
	)
)
