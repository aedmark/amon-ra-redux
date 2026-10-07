;;; Sierra Script 1.0 - (do not remove this comment)
(script# 16)
(include sci.sh)
(use Main)
(use PolyPath)
(use Polygon)
(use Sound)
(use Cycle)
(use View)


(class Door of Prop
	(properties
		sel_20 {Door}
		sel_1 0
		sel_0 0
		sel_82 0
		sel_55 0
		sel_213 0
		sel_214 -1
		sel_6 0
		sel_7 0
		sel_8 0
		sel_9 0
		sel_301 26505
		sel_299 0
		sel_302 26505
		sel_303 0
		sel_304 0
		sel_305 0
		sel_306 0
		sel_52 2
		sel_2 -1
		sel_3 0
		sel_4 0
		sel_60 0
		sel_5 0
		sel_14 0
		sel_10 0
		sel_11 0
		sel_12 0
		sel_13 0
		sel_16 0
		sel_17 0
		sel_18 0
		sel_19 0
		sel_88 0
		sel_103 0
		sel_104 128
		sel_105 128
		sel_106 128
		sel_244 6
		sel_142 0
		sel_245 0
		sel_135 0
		sel_321 0
		sel_322 0
		sel_589 0
		sel_590 0
		sel_591 46
		sel_592 47
		sel_593 0
		sel_29 0
		sel_594 0
		sel_595 0
		sel_596 1
		sel_143 0
		sel_597 0
		sel_598 0
		sel_599 2
		sel_600 2
		sel_601 0
		sel_602 0
		sel_603 0
		sel_604 5
	)
	
	(method (sel_110)
		(self sel_311: 4 18)
		(if
		(or sel_595 (and gGSel_40 (== gGSel_40 sel_589)))
			(= sel_29 2)
		)
		(super sel_110:)
		(self sel_606:)
		(self sel_316: 1)
		(if (== sel_29 0)
			(= sel_4 0)
			(if sel_594 (sel_594 sel_156: 0))
		else
			(gListSel_109 sel_81: sel_603)
			(= sel_4 (- (NumCels self) 1))
			(if sel_594 (sel_594 sel_156: 255))
		)
		(if (== sel_29 2)
			(if sel_601
				(self sel_146: sel_601)
			else
				(switch sel_599
					(0
						(gEgo
							sel_153: sel_597 sel_598
							sel_312: PolyPath sel_303 sel_304 self
						)
					)
					(1
						(gEgo sel_349: 0 sel_153: sel_303 sel_304 sel_253: sel_55)
						(if sel_596 (self sel_360:))
					)
					(2
						(if sel_596 (self sel_360:))
					)
				)
			)
		else
			(self sel_313:)
		)
	)
	
	(method (sel_111)
		(gListSel_109 sel_81: sel_603)
		(sel_603 sel_111:)
		(super sel_111: &rest)
	)
	
	(method (sel_300 param1)
		(switch param1
			(4
				(if (== sel_29 2) (self sel_360:) else (self sel_189:))
			)
			(18
				(if sel_4
					(gLb2Messager sel_295: 1 18 2 0 0 16)
				else
					(gLb2Messager sel_295: 1 18 1 0 0 16)
				)
			)
			(sel_593 (self sel_605:))
			(else  (super sel_300: param1))
		)
	)
	
	(method (sel_145)
		(switch sel_29
			(3
				(= sel_29 0)
				(self sel_313:)
				(gListSel_109 sel_118: sel_603)
				(if sel_143 (sel_143 sel_145:))
				(if (not (gUser sel_343?)) (gGame sel_588: 1))
			)
			(1
				(= sel_29 2)
				(self sel_313:)
				(gListSel_109 sel_81: sel_603)
				(if sel_143 (sel_143 sel_145:))
				(if sel_602
					(self sel_146: sel_602)
				else
					(switch sel_600
						(0
							(if (or sel_597 sel_598)
								(gEgo sel_15: 0 sel_312: PolyPath sel_597 sel_598 self)
							)
						)
						(1
							(if (or sel_597 sel_598)
								(gEgo sel_312: PolyPath sel_597 sel_598 self)
							)
						)
						(2
							(if (not (gUser sel_343?)) (gGame sel_588: 1))
						)
					)
				)
			)
			(else 
				(cond 
					(
						(and
							(== (gEgo sel_1?) sel_597)
							(== (gEgo sel_0?) sel_598)
						)
						(cond 
							(sel_589
								(switch sel_589
									((global2 sel_409?)
										(gEgo sel_349: 1)
									)
									((global2 sel_411?)
										(gEgo sel_349: 3)
									)
									((global2 sel_412?)
										(gEgo sel_349: 4)
									)
									((global2 sel_410?)
										(gEgo sel_349: 2)
									)
								)
								(global2 sel_399: sel_589)
							)
							(sel_596 (self sel_360:))
							(sel_143 (sel_143 sel_145:))
						)
					)
					(
						(and
							(== (gEgo sel_1?) sel_303)
							(== (gEgo sel_0?) sel_304)
						)
						(cond 
							(sel_596 (self sel_360:))
							(sel_143 (sel_143 sel_145:))
						)
					)
				)
			)
		)
	)
	
	(method (sel_189)
		(if sel_590
			(doorSound sel_40: 48 sel_39:)
			(gLb2Messager sel_295: 1 0 3 0 0 16)
		else
			(if (gUser sel_343?) (gGame sel_587:))
			(= sel_29 1)
			(self sel_161: End self)
			(if sel_591 (doorSound sel_40: sel_591 sel_39:))
			(if sel_594 (sel_594 sel_161: End))
		)
	)
	
	(method (sel_360)
		(= sel_29 3)
		(self sel_161: Beg self)
		(if sel_592 (doorSound sel_40: sel_592 sel_39:))
		(if sel_594 (sel_594 sel_161: Beg))
	)
	
	(method (sel_605)
		(gLb2Messager sel_295: 1 0 4 0 0 16)
	)
	
	(method (sel_606)
		(= sel_603 ((Polygon sel_109:) sel_31: 2 sel_117:))
		(if argc
			(sel_603 sel_110: &rest)
		else
			(sel_603
				sel_110:
					(- sel_17 sel_604)
					(+ sel_18 sel_604)
					(- sel_17 sel_604)
					(- sel_16 sel_604)
					(+ sel_19 sel_604)
					(- sel_16 sel_604)
					(+ sel_19 sel_604)
					(+ sel_18 sel_604)
			)
		)
		(gListSel_109 sel_118: sel_603)
	)
)

(instance doorSound of Sound
	(properties
		sel_20 {doorSound}
		sel_99 5
	)
)
