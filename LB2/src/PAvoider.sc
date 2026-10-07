;;; Sierra Script 1.0 - (do not remove this comment)
(script# 927)
(include sci.sh)
(use PolyPath)
(use Polygon)
(use Obj)


(procedure (localproc_03f0 param1 &tmp temp0 [temp1 2] temp3 temp4)
	(= temp3 -100)
	(= temp0 0)
	(while (!= temp3 30583)
		(= temp3 (proc999_6 param1 (* 2 temp0)))
		(++ temp0)
	)
	(return (-- temp0))
)

(procedure (localproc_0419 param1 &tmp temp0 temp1 temp2 temp3)
	(= temp3 (param1 sel_86?))
	(= temp0 0)
	(while (< temp0 temp3)
		(if
			(>=
				(= temp2 ((= temp1 (param1 sel_64: temp0)) sel_31?))
				16
			)
			(temp1 sel_31: (- temp2 16))
		)
		(++ temp0)
	)
)

(class PAvoider of Code
	(properties
		sel_20 {PAvoider}
		sel_42 0
		sel_529 0
		sel_530 0
		sel_531 -99
		sel_532 -99
	)
	
	(method (sel_110 theSel_42)
		(if (>= argc 1) (= sel_42 theSel_42))
	)
	
	(method (sel_57 &tmp temp0 temp1 temp2 temp3 theSel_529 temp5 temp6 temp7 temp8 sel_42Sel_56 [temp10 4] temp14 polygonSel_109 temp16 temp17 [temp18 5] sel_42Sel_55)
		(= sel_42Sel_56 (sel_42 sel_56?))
		(if
			(and
				sel_529
				(or
					(not sel_42Sel_56)
					(>= (sel_42 sel_255: sel_529) 20)
					(!= (sel_42Sel_56 sel_257?) sel_531)
					(!= (sel_42Sel_56 sel_258?) sel_532)
				)
			)
			(sel_529 sel_316: 0)
			(if sel_530 (sel_529 sel_56: sel_530))
			(= sel_532 (= sel_531 -99))
			(= sel_529 (= sel_530 0))
		)
		(if
			(and
				(= sel_42Sel_56 (sel_42 sel_56?))
				(IsObject (= theSel_529 (sel_42Sel_56 sel_57:)))
				(not (sel_42Sel_56 sel_240?))
				(sel_42Sel_56 sel_114: PolyPath)
				(IsObject (sel_42Sel_56 sel_259?))
			)
			(= sel_530 (theSel_529 sel_56?))
			(if sel_530 (theSel_529 sel_56: 0))
			(= sel_531 (sel_42Sel_56 sel_257?))
			(= sel_532 (sel_42Sel_56 sel_258?))
			((= sel_529 theSel_529) sel_316: 1)
			(= temp5
				(-
					(theSel_529 sel_17?)
					(= temp2
						(+
							(* 2 (sel_42 sel_51?))
							(/
								(proc999_3
									(CelWide (sel_42 sel_2?) 2 0)
									(CelWide (sel_42 sel_2?) 0 0)
								)
								2
							)
						)
					)
				)
			)
			(= temp6 (CoordPri 1 (CoordPri (theSel_529 sel_0?))))
			(= temp3 (* 2 (theSel_529 sel_52?)))
			(= temp7 (+ (theSel_529 sel_19?) temp2))
			(if
				(<=
					(- (= temp8 (+ (theSel_529 sel_0?) temp3 2)) temp6)
					3
				)
				(= temp6 (- temp6 2))
				(= temp8 (+ temp8 2))
			)
			(= temp0 (- (sel_42Sel_56 sel_257?) (sel_42 sel_1?)))
			(= temp1 (- (sel_42Sel_56 sel_258?) (sel_42 sel_0?)))
			(cond 
				(
					(and
						(<= 85 (= sel_42Sel_55 (sel_42 sel_55?)))
						(<= sel_42Sel_55 95)
					)
					(= temp14 0)
				)
				(
				(and (<= 265 sel_42Sel_55) (<= sel_42Sel_55 275)) (= temp14 1))
				((>= temp1 0) (= temp14 2))
				(else (= temp14 3))
			)
			(switch temp14
				(3
					(= temp17
						((Polygon sel_109:)
							sel_110:
								temp5
								(sel_42 sel_0?)
								temp5
								temp6
								temp7
								temp6
								temp7
								(sel_42 sel_0?)
								30583
								0
							sel_31: 2
							sel_20: {isBlockedPoly}
							sel_117:
						)
					)
				)
				(2
					(= temp17
						((Polygon sel_109:)
							sel_110:
								temp7
								(sel_42 sel_0?)
								temp7
								temp8
								temp5
								temp8
								temp5
								(sel_42 sel_0?)
								30583
								0
							sel_31: 2
							sel_20: {isBlockedPoly}
							sel_117:
						)
					)
				)
				(0
					(= temp17
						((Polygon sel_109:)
							sel_110:
								(sel_42 sel_1?)
								temp6
								temp7
								temp6
								temp7
								temp8
								(sel_42 sel_1?)
								temp8
								30583
								0
							sel_31: 2
							sel_20: {isBlockedPoly}
							sel_117:
						)
					)
				)
				(1
					(= temp17
						((Polygon sel_109:)
							sel_110:
								(sel_42 sel_1?)
								temp8
								temp5
								temp8
								temp5
								temp6
								(sel_42 sel_1?)
								temp6
								30583
								0
							sel_31: 2
							sel_20: {isBlockedPoly}
							sel_117:
						)
					)
				)
			)
			(if
				(= temp16
					(MergePoly
						(temp17 sel_87:)
						((sel_42Sel_56 sel_259?) sel_24?)
						((sel_42Sel_56 sel_259?) sel_86?)
					)
				)
				((= polygonSel_109 (Polygon sel_109:))
					sel_87: temp16
					sel_86: (localproc_03f0 temp16)
					sel_31: 2
					sel_256: 1
				)
			)
			((sel_42Sel_56 sel_259?) sel_118: polygonSel_109)
			(sel_42Sel_56
				sel_74: 2
				sel_110: sel_42 (sel_42Sel_56 sel_257?) (sel_42Sel_56 sel_258?)
			)
			((sel_42Sel_56 sel_259?) sel_81: polygonSel_109)
			((sel_42Sel_56 sel_259?) sel_81: temp17)
			(localproc_0419 (sel_42Sel_56 sel_259?))
			(temp17 sel_111:)
			(polygonSel_109 sel_111:)
		)
	)
	
	(method (sel_111)
		(if (IsObject sel_530) (sel_530 sel_111:))
		(super sel_111: &rest)
	)
)
