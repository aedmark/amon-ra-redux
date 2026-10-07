;;; Sierra Script 1.0 - (do not remove this comment)
(script# 740)
(include sci.sh)
(use Main)
(use LBRoom)
(use RTRandCycle)
(use PChase)
(use Osc)
(use PolyPath)
(use CueObj)
(use n958)
(use Sound)
(use Jump)
(use Cycle)
(use View)
(use Obj)

(public
	rm740 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
)
(instance rm740 of LBRoom
	(properties
		sel_20 {rm740}
		sel_213 9
		sel_408 740
		sel_409 480
		sel_412 730
	)
	
	(method (sel_110)
		(global2 sel_259: (List sel_109:))
		((ScriptID 2740 0) sel_57: (global2 sel_259?))
		(gEgo
			sel_110:
			sel_585: 732
			sel_316: 1
			sel_299: egoActions
		)
		(gGame sel_587:)
		(proc958_0 128 734 742 812 745)
		(proc958_0 132 736 52)
		(Palette palSET_INTENSITY 0 255 0)
		(super sel_110:)
		(sFXRats sel_39:)
		(gIconBar sel_233: 7)
		(= local0 1)
		(steve sel_110:)
		(rat1 sel_110: sel_161: RTRandCycle)
		(rat2 sel_110: sel_161: RTRandCycle)
		(rat3 sel_110: sel_161: RTRandCycle)
		(rat4 sel_110: sel_161: RTRandCycle)
		(rat5 sel_110: sel_161: RTRandCycle)
		(floor sel_110:)
		(wall sel_110:)
		(furnaceExit sel_110:)
		(tRexExit sel_110:)
		(gLb2DH sel_118: self)
		(gLb2WH sel_118: self)
		(self sel_146: sEnterSouth)
	)
	
	(method (sel_57)
		(super sel_57:)
		(if local0
			(Palette palSET_INTENSITY 0 255 (= local1 (+ local1 2)))
			(if (>= local1 100)
				(= local0 0)
				(steve sel_146: sGunShots)
			)
		)
		(cond 
			(sel_142)
			((proc0_1 gEgo 2) (self sel_146: sBurnEm))
			((proc0_1 gEgo 4) (self sel_146: sGoTRex))
			(
			(and (> (gEgo sel_1?) 211) (== (gEgo sel_2?) 732)) (gEgo sel_2: 745 sel_244: 6 sel_53: 6 sel_51: 3))
			(
			(and (< (gEgo sel_1?) 212) (== (gEgo sel_2?) 745)) (gEgo sel_2: 732 sel_244: 4 sel_53: 4 sel_51: 2))
		)
	)
	
	(method (sel_111)
		(proc958_0 0 930 991)
		(gLb2DH sel_81: self)
		(gLb2WH sel_81: self)
		(DisposeScript 2740)
		(gSel_608 sel_170:)
		(super sel_111:)
	)
	
	(method (sel_133 param1)
		(return
			(cond 
				(
					(and
						(& (param1 sel_31?) $0040)
						(== (gIconBar sel_207?) (gIconBar sel_228?))
						(or
							(== (param1 sel_37?) 7)
							(== (param1 sel_37?) 8)
							(== (param1 sel_37?) 6)
						)
					)
					(param1 sel_73: 1)
				)
				((& (param1 sel_31?) $1000)
					(if (< gSel_1 (gEgo sel_1?))
						(param1 sel_73: 1)
					else
						(return 0)
					)
				)
				(else (return 0))
			)
		)
	)
	
	(method (sel_145)
		(gGameMusic2 sel_40: 16 sel_3: -1 sel_99: 1 sel_39:)
	)
)

(instance sGunShots of Script
	(properties
		sel_20 {sGunShots}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(sFX sel_40: 52 sel_99: 5 sel_39: self)
			)
			(1 (= sel_139 30))
			(2 (sFX sel_39: self))
			(3
				(gLb2Messager sel_295: 8 0 0 0 global2)
				(gGame sel_588:)
				(gIconBar sel_233: 7)
				(self sel_111:)
			)
		)
	)
)

(instance sEnterSouth of Script
	(properties
		sel_20 {sEnterSouth}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(steve
					sel_155: 0
					sel_161: Walk
					sel_244: 4
					sel_53: 4
					sel_51: 2
					sel_312: PFollow gEgo 36
				)
				(gEgo
					sel_155: 0
					sel_153: 10 209
					sel_349: 0
					sel_161: Walk
					sel_244: 4
					sel_53: 4
					sel_51: 2
					sel_312: MoveTo 89 163 self
				)
			)
			(1
				(rat3 sel_146: sRat3Movement)
				(self sel_111:)
			)
		)
	)
)

(instance sBurnEm of Script
	(properties
		sel_20 {sBurnEm}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(gEgo
					sel_2: 744
					sel_155: 2
					sel_156: 0
					sel_316: 1
					sel_244: 12
					sel_161: End self
				)
				(steve sel_316: 1)
			)
			(1
				(gGameMusic2 sel_167:)
				(sFXFall sel_39:)
				(gEgo
					sel_63: 5
					sel_53: 3
					sel_52: 4
					sel_161: 0
					sel_312: MoveTo (gEgo sel_1?) (+ (gEgo sel_0?) 15) self
				)
			)
			(2
				(gEgo sel_111:)
				(steve sel_312: PolyPath 239 106 self)
			)
			(3
				(sFXFall sel_39:)
				(steve sel_2: 744 sel_155: 1 sel_156: 0 sel_161: End self)
			)
			(4
				(steve
					sel_63: 5
					sel_53: 3
					sel_52: 4
					sel_312: MoveTo (steve sel_1?) (+ (steve sel_0?) 40) self
				)
			)
			(5 (= sel_139 120))
			(6
				(gSel_608 sel_40: 736 sel_99: 1 sel_3: 1 sel_39:)
				(furnaceExit sel_161: Osc 1 self)
			)
			(7 (= sel_139 120))
			(8
				(gSel_608 sel_40: 736 sel_99: 1 sel_3: 1 sel_39:)
				(furnaceExit sel_161: CT 4 1 self)
			)
			(9
				(furnaceExit sel_161: Beg self)
			)
			(10 (= sel_137 3))
			(11
				(= global145 2)
				(global2 sel_399: 99)
				(self sel_111:)
			)
		)
	)
)

(instance sGoTRex of Script
	(properties
		sel_20 {sGoTRex}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(gEgo
					sel_2: 745
					sel_155: 1
					sel_316: 1
					sel_244: 10
					sel_161: End self
				)
				(steve sel_316: 1)
			)
			(1
				(steve sel_312: PolyPath 290 106 self)
			)
			(2
				(steve
					sel_2: 745
					sel_155: 2
					sel_244: 10
					sel_161: End self
					sel_312: MoveTo (gEgo sel_1?) (- (gEgo sel_0?) 2)
				)
			)
			(3
				(steve sel_111:)
				(= sel_136 2)
			)
			(4
				(global2 sel_399: (global2 sel_409?))
				(self sel_111:)
			)
		)
	)
)

(instance sRat3Movement of Script
	(properties
		sel_20 {sRat3Movement}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0 (= sel_137 2))
			(1
				(rat3
					sel_3: 1
					sel_161: Walk
					sel_244: 6
					sel_312: MoveTo (- (rat3 sel_1?) 30) (+ (rat3 sel_0?) 16) self
				)
			)
			(2
				(rat3
					sel_312: MoveTo (+ (rat3 sel_1?) 30) (- (rat3 sel_0?) 16) self
				)
			)
			(3
				(rat3 sel_155: 3 sel_244: 12 sel_161: RTRandCycle)
				(rat4 sel_146: sRat4Movement)
				(self sel_111:)
			)
		)
	)
)

(instance sRat4Movement of Script
	(properties
		sel_20 {sRat4Movement}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(rat4
					sel_3: 1
					sel_161: Walk
					sel_244: 6
					sel_312: MoveTo (- (rat4 sel_1?) 36) (+ (rat4 sel_0?) 21) self
				)
			)
			(1
				(rat4
					sel_312: MoveTo (+ (rat4 sel_1?) 36) (- (rat4 sel_0?) 21) self
				)
			)
			(2
				(rat4 sel_155: 3 sel_244: 12 sel_161: RTRandCycle)
				(rat5 sel_146: sRat5Movement)
				(self sel_111:)
			)
		)
	)
)

(instance sRat5Movement of Script
	(properties
		sel_20 {sRat5Movement}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(rat5
					sel_3: 1
					sel_161: Walk
					sel_244: 6
					sel_312: MoveTo (- (rat5 sel_1?) 40) (+ (rat5 sel_0?) 22) self
				)
			)
			(1
				(rat5
					sel_312: MoveTo (+ (rat5 sel_1?) 40) (- (rat5 sel_0?) 22) self
				)
			)
			(2
				(rat5 sel_155: 3 sel_244: 12 sel_161: RTRandCycle)
				(= sel_137 4)
			)
			(3
				(rat1
					sel_155: 1
					sel_244: 6
					sel_161: Walk
					sel_312: MoveTo 51 182
				)
				(rat2
					sel_155: 1
					sel_244: 6
					sel_161: Walk
					sel_312: MoveTo 59 172
				)
				(rat3
					sel_155: 1
					sel_244: 6
					sel_161: Walk
					sel_312: MoveTo 66 175
				)
				(rat4
					sel_155: 1
					sel_244: 6
					sel_161: Walk
					sel_312: MoveTo 76 165
				)
				(rat5
					sel_155: 1
					sel_244: 6
					sel_161: Walk
					sel_312: MoveTo 84 165
				)
				(self sel_111:)
			)
		)
	)
)

(instance sKillLaura of Script
	(properties
		sel_20 {sKillLaura}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(gGameMusic2 sel_40: 3 sel_3: 1 sel_99: 1 sel_39:)
				(= local5 1)
				(rat1 sel_155: 3 sel_161: Fwd sel_312: 0)
				(rat2 sel_155: 3 sel_161: Fwd sel_312: 0)
				(rat3
					sel_155: 9
					sel_63: 15
					sel_312: MoveTo (rat3 sel_1?) (- (rat3 sel_0?) 24) self
				)
				(rat4 sel_155: 3 sel_161: Fwd sel_312: 0)
				(rat5 sel_155: 3 sel_161: Fwd sel_312: 0)
			)
			(1
				(gEgo
					sel_2: 734
					sel_155: 0
					sel_156: 0
					sel_244: 9
					sel_161: End
				)
				(rat3
					sel_155: 10
					sel_312: MoveTo (rat3 sel_1?) (+ (rat3 sel_0?) 24) self
				)
			)
			(2
				(rat1 sel_155: 1 sel_161: Walk sel_312: MoveTo 49 183)
				(rat2 sel_155: 1 sel_161: Walk sel_312: MoveTo 57 173)
				(rat3 sel_155: 1 sel_161: Walk sel_312: MoveTo 64 176)
				(rat4 sel_155: 1 sel_161: Walk sel_312: MoveTo 74 166)
				(rat5 sel_155: 1 sel_161: Walk sel_312: MoveTo 82 166)
				(self sel_111:)
			)
		)
	)
)

(instance sKillSteve of Script
	(properties
		sel_20 {sKillSteve}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(= local6 1)
				(rat1 sel_155: 3 sel_161: Fwd sel_312: 0)
				(rat2 sel_155: 3 sel_161: Fwd sel_312: 0)
				(rat3
					sel_312: MoveTo (- (rat3 sel_1?) 7) (+ (rat3 sel_0?) 4) self
				)
				(rat4 sel_155: 3 sel_161: Fwd sel_312: 0)
				(rat5 sel_155: 3 sel_161: Fwd sel_312: 0)
			)
			(1
				(rat3
					sel_155: 9
					sel_63: 15
					sel_312: MoveTo (rat3 sel_1?) (- (rat3 sel_0?) 18) self
				)
			)
			(2
				(steve
					sel_2: 734
					sel_155: 1
					sel_156: 0
					sel_244: 9
					sel_316: 1
					sel_161: End
				)
				(rat3
					sel_155: 10
					sel_312: MoveTo (rat3 sel_1?) (+ (rat3 sel_0?) 18) self
				)
			)
			(3
				(rat3 sel_155: 3 sel_161: Fwd)
				(gGameMusic2 sel_170: self)
			)
			(4
				(= global145 8)
				(global2 sel_399: 99)
				(self sel_111:)
			)
		)
	)
)

(instance sRatsEatCheese of Script
	(properties
		sel_20 {sRatsEatCheese}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(rat1 sel_155: 3 sel_161: Fwd sel_312: 0)
				(rat2 sel_155: 3 sel_161: Fwd sel_312: 0)
				(if (rat3 sel_142?)
					(rat3 sel_146: sRat3Return)
				else
					(rat3 sel_155: 3 sel_161: Fwd sel_312: 0)
				)
				(if (rat4 sel_142?)
					(rat4 sel_146: sRat4Return)
				else
					(rat4 sel_155: 3 sel_161: Fwd sel_312: 0)
				)
				(if (rat5 sel_142?)
					(rat5 sel_146: sRat5Return)
				else
					(rat5 sel_155: 3 sel_161: Fwd sel_312: 0)
				)
				(gEgo
					sel_2: 742
					sel_155: 0
					sel_156: 0
					sel_244: 6
					sel_161: End self
				)
			)
			(1
				(gEgo sel_161: Beg)
				(cheese
					sel_110:
					sel_153: (+ (gEgo sel_1?) 30) (- (gEgo sel_0?) 31)
					sel_312: JumpTo (- (rat2 sel_1?) 2) (+ (rat2 sel_0?) 1) self
				)
			)
			(2
				(gEgo sel_351: 16)
				((ScriptID 21 1) sel_57: 785)
				(= sel_139 90)
			)
			(3
				(gLb2Messager sel_295: 4 27)
				(cheese sel_111:)
				(gEgo sel_2: 732 sel_155: 0 sel_156: 0)
				(rat1
					sel_155: 1
					sel_244: 6
					sel_161: Walk
					sel_312: MoveTo 51 182
				)
				(rat2
					sel_155: 1
					sel_244: 6
					sel_161: Walk
					sel_312: MoveTo 59 172
				)
				(rat3
					sel_155: 1
					sel_244: 6
					sel_161: Walk
					sel_312: MoveTo 66 175
				)
				(rat4
					sel_155: 1
					sel_244: 6
					sel_161: Walk
					sel_312: MoveTo 76 165
				)
				(rat5
					sel_155: 1
					sel_244: 6
					sel_161: Walk
					sel_312: MoveTo 84 165
				)
				(self sel_111:)
			)
		)
	)
)

(instance sRat3Return of Script
	(properties
		sel_20 {sRat3Return}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(rat3 sel_312: MoveTo 177 111 self)
			)
			(1
				(rat3 sel_155: 3 sel_161: Fwd)
				(self sel_111:)
			)
		)
	)
)

(instance sRat4Return of Script
	(properties
		sel_20 {sRat4Return}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(rat4 sel_312: MoveTo 187 101 self)
			)
			(1
				(rat4 sel_155: 3 sel_161: Fwd)
				(self sel_111:)
			)
		)
	)
)

(instance sRat5Return of Script
	(properties
		sel_20 {sRat5Return}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(rat5 sel_312: MoveTo 195 101 self)
			)
			(1
				(rat5 sel_155: 3 sel_161: Fwd)
				(self sel_111:)
			)
		)
	)
)

(instance sRatsEnterFurnace of Script
	(properties
		sel_20 {sRatsEnterFurnace}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(rat1 sel_155: 3 sel_161: Fwd sel_312: 0)
				(rat2 sel_155: 3 sel_161: Fwd sel_312: 0)
				(rat3 sel_155: 3 sel_146: 0 sel_161: Fwd sel_312: 0)
				(rat4 sel_155: 3 sel_146: 0 sel_161: Fwd sel_312: 0)
				(rat5 sel_155: 3 sel_146: 0 sel_161: Fwd sel_312: 0)
				(gEgo
					sel_2: 742
					sel_155: 0
					sel_156: 0
					sel_244: 6
					sel_161: End self
				)
			)
			(1
				(gEgo sel_161: Beg)
				(cheese
					sel_110:
					sel_153: (+ (gEgo sel_1?) 30) (- (gEgo sel_0?) 31)
					sel_53: 6
					sel_63: 5
					sel_312: JumpTo 245 108 self
				)
			)
			(2
				(cheese sel_111:)
				(gEgo sel_2: 732 sel_155: 0 sel_161: Walk sel_351: 16)
				((ScriptID 21 1) sel_57: 785)
				(rat1
					sel_155: 0
					sel_161: Walk
					sel_312: MoveTo 194 105 self
				)
			)
			(3
				(rat1 sel_155: 4 sel_312: MoveTo 211 104 self)
			)
			(4
				(rat1 sel_155: 6 sel_244: 6 sel_161: Osc 1 self)
			)
			(5
				(rat1 sel_161: 0 sel_63: 5 sel_312: JumpTo 239 114 self)
			)
			(6
				(rat1 sel_111:)
				(rat2
					sel_155: 0
					sel_161: Walk
					sel_312: MoveTo 190 107 self
				)
			)
			(7
				(rat2 sel_161: Fwd sel_63: 5 sel_312: JumpTo 238 117 self)
			)
			(8
				(rat2 sel_111:)
				(rat3
					sel_155: 0
					sel_161: Walk
					sel_312: MoveTo 194 105 self
				)
			)
			(9
				(rat3 sel_155: 4 sel_312: MoveTo 228 98 self)
			)
			(10
				(rat3 sel_155: 6 sel_244: 6 sel_161: Osc 1 self)
			)
			(11
				(rat3
					sel_63: 5
					sel_53: 0
					sel_52: 4
					sel_312: MoveTo 228 110 self
				)
			)
			(12
				(rat3 sel_111:)
				(rat4
					sel_155: 0
					sel_161: Walk
					sel_312: MoveTo 194 105 self
				)
			)
			(13
				(rat4 sel_155: 4 sel_312: MoveTo 211 104 self)
			)
			(14
				(rat4 sel_161: Fwd sel_63: 5 sel_312: JumpTo 246 94 self)
			)
			(15
				(rat4 sel_155: 2 sel_156: 7 sel_161: 0 sel_53: 9)
				(= sel_139 45)
			)
			(16
				(rat4 sel_312: MoveTo 246 110 self)
			)
			(17
				(rat4 sel_111:)
				(rat5
					sel_155: 0
					sel_161: Walk
					sel_312: MoveTo 190 107 self
				)
			)
			(18
				(rat5
					sel_155: 8
					sel_244: 9
					sel_161: Fwd
					sel_63: 5
					sel_312: JumpTo 238 117 self
				)
			)
			(19
				(rat5 sel_111:)
				(sFXRats sel_170:)
				(gLb2Messager sel_295: 7 0 8)
				(= local2 1)
				(gGame sel_588:)
				(self sel_111:)
			)
		)
	)
)

(instance sRatsEnterRex of Script
	(properties
		sel_20 {sRatsEnterRex}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(rat1 sel_155: 3 sel_161: Fwd sel_312: 0)
				(rat2 sel_155: 3 sel_161: Fwd sel_312: 0)
				(rat3 sel_155: 3 sel_146: 0 sel_161: Fwd sel_312: 0)
				(rat4 sel_155: 3 sel_146: 0 sel_161: Fwd sel_312: 0)
				(rat5 sel_155: 3 sel_146: 0 sel_161: Fwd sel_312: 0)
				(gEgo
					sel_2: 742
					sel_155: 0
					sel_156: 0
					sel_244: 6
					sel_161: End self
				)
			)
			(1
				(gEgo sel_161: Beg)
				(cheese
					sel_110:
					sel_153: (+ (gEgo sel_1?) 30) (- (gEgo sel_0?) 31)
					sel_53: 6
					sel_63: 5
					sel_312: JumpTo 295 105 self
				)
			)
			(2
				(cheese sel_111:)
				(gEgo sel_2: 732 sel_155: 0 sel_161: Walk sel_351: 16)
				((ScriptID 21 1) sel_57: 785)
				(rat1
					sel_155: 0
					sel_161: Walk
					sel_312: MoveTo 194 105 self
				)
			)
			(3
				(rat1 sel_155: 4 sel_312: MoveTo 266 103 self)
			)
			(4
				(rat1 sel_155: 6 sel_244: 6 sel_161: Osc 1 self)
			)
			(5
				(rat1 sel_161: 0 sel_63: 5 sel_312: JumpTo 291 112 self)
			)
			(6
				(rat1 sel_111:)
				(rat2
					sel_155: 0
					sel_161: Walk
					sel_312: MoveTo 190 107 self
				)
			)
			(7
				(rat2 sel_161: Fwd sel_63: 5 sel_312: JumpTo 291 112 self)
			)
			(8
				(rat2 sel_111:)
				(rat3
					sel_155: 0
					sel_161: Walk
					sel_312: MoveTo 194 105 self
				)
			)
			(9
				(rat3 sel_155: 4 sel_312: MoveTo 266 103 self)
			)
			(10
				(rat3 sel_155: 4 sel_312: MoveTo 281 98 self)
			)
			(11
				(rat3 sel_155: 6 sel_244: 6 sel_161: Osc 1 self)
			)
			(12
				(rat3
					sel_63: 5
					sel_53: 0
					sel_52: 4
					sel_312: MoveTo 281 111 self
				)
			)
			(13
				(rat3 sel_111:)
				(rat4
					sel_155: 0
					sel_161: Walk
					sel_312: MoveTo 194 105 self
				)
			)
			(14
				(rat4 sel_155: 4 sel_312: MoveTo 271 103 self)
			)
			(15
				(rat4 sel_161: Fwd sel_63: 5 sel_312: JumpTo 299 94 self)
			)
			(16
				(rat4 sel_155: 2 sel_156: 7 sel_161: 0 sel_53: 9)
				(= sel_139 45)
			)
			(17
				(rat4 sel_312: MoveTo 299 119 self)
			)
			(18
				(rat4 sel_111:)
				(rat5
					sel_155: 0
					sel_161: Walk
					sel_312: MoveTo 190 107 self
				)
			)
			(19
				(rat5
					sel_155: 8
					sel_244: 9
					sel_161: Fwd
					sel_63: 5
					sel_312: JumpTo 283 112 self
				)
			)
			(20
				(rat5 sel_111:)
				(sFXRats sel_170:)
				(gLb2Messager sel_295: 7 0 9)
				(= local2 1)
				(proc0_3 46)
				(gGame sel_588:)
				(gIconBar sel_233: 7)
				(self sel_111:)
			)
		)
	)
)

(instance egoActions of Actions
	(properties
		sel_20 {egoActions}
	)
	
	(method (sel_300 param1)
		(switch param1
			(27
				(gLb2Messager sel_295: 6 27)
			)
			(else  0)
		)
	)
)

(instance steve of Actor
	(properties
		sel_20 {steve}
		sel_1 -10
		sel_0 222
		sel_213 5
		sel_2 733
		sel_14 16384
	)
	
	(method (sel_57)
		(super sel_57:)
		(cond 
			(sel_142)
			(
			(and (> (self sel_1?) 211) (== (self sel_2?) 733))
				(self
					sel_2: 812
					sel_244: 6
					sel_53: 6
					sel_51: 3
					sel_103: 1
				)
			)
		)
	)
	
	(method (sel_300 param1)
		(switch param1
			(1
				(gLb2Messager sel_295: 1 1 27 0 0 1887)
			)
			(4
				(gLb2Messager sel_295: 1 4 27 0 0 1887)
			)
			(8
				(gLb2Messager sel_295: 1 8 27 0 0 1887)
			)
			(2
				(if local2
					(gLb2Messager sel_295: 5 2 7)
				else
					(switch local4
						(0 (gLb2Messager sel_295: 5 2))
						(else 
							(gLb2Messager sel_295: 5 2 6)
						)
					)
					(++ local4)
				)
			)
			(27
				(gEgo sel_351: 16)
				((ScriptID 21 1) sel_57: 785)
				(gLb2Messager sel_295: 5 27)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance cheese of Actor
	(properties
		sel_20 {cheese}
		sel_52 1
		sel_2 742
		sel_3 2
		sel_51 1
		sel_53 9
	)
)

(instance rat1 of Actor
	(properties
		sel_20 {rat1}
		sel_1 162
		sel_0 118
		sel_213 4
		sel_2 741
		sel_3 3
		sel_14 16384
		sel_244 18
		sel_53 4
	)
	
	(method (sel_300)
		(rat3 sel_300: &rest)
	)
)

(instance rat2 of Actor
	(properties
		sel_20 {rat2}
		sel_1 170
		sel_0 108
		sel_213 4
		sel_2 741
		sel_3 3
		sel_14 16384
		sel_244 18
		sel_53 4
	)
	
	(method (sel_300)
		(rat3 sel_300: &rest)
	)
)

(instance rat3 of Actor
	(properties
		sel_20 {rat3}
		sel_1 177
		sel_0 111
		sel_213 4
		sel_2 741
		sel_3 3
		sel_14 16384
		sel_244 18
		sel_53 4
	)
	
	(method (sel_57)
		(super sel_57:)
		(cond 
			(sel_142)
			(
				(and
					(< (self sel_255: gEgo) 5)
					(== (gEgo sel_2?) 732)
					(not local5)
				)
				(global2 sel_146: sKillLaura)
			)
			(
				(and
					(< (self sel_255: steve) 10)
					(== (steve sel_2?) 733)
					(not local6)
				)
				(global2 sel_146: sKillSteve)
			)
		)
	)
	
	(method (sel_300 param1)
		(switch param1
			(1
				(switch local3
					(0
						(gLb2Messager sel_295: 4 1 3)
					)
					(1
						(gLb2Messager sel_295: 4 1 4)
					)
					(else 
						(gLb2Messager sel_295: 4 1 5)
					)
				)
				(++ local3)
			)
			(27
				(global2 sel_146: sRatsEatCheese)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance rat4 of Actor
	(properties
		sel_20 {rat4}
		sel_1 187
		sel_0 101
		sel_213 4
		sel_2 741
		sel_3 3
		sel_14 16384
		sel_244 18
		sel_53 4
	)
	
	(method (sel_300)
		(rat3 sel_300: &rest)
	)
)

(instance rat5 of Actor
	(properties
		sel_20 {rat5}
		sel_1 195
		sel_0 101
		sel_213 4
		sel_2 741
		sel_3 3
		sel_14 16384
		sel_244 18
		sel_53 4
	)
	
	(method (sel_300)
		(rat3 sel_300: &rest)
	)
)

(instance furnaceExit of Prop
	(properties
		sel_20 {furnaceExit}
		sel_1 253
		sel_0 33
		sel_213 3
		sel_2 744
		sel_14 16385
	)
	
	(method (sel_300 param1)
		(switch param1
			(1
				(if (< (gEgo sel_1?) 202)
					(gLb2Messager sel_295: 3 1 1)
				else
					(gLb2Messager sel_295: 3 1 2)
				)
			)
			(27
				(if local2
					(super sel_300: param1)
				else
					(global2 sel_146: sRatsEnterFurnace)
				)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance tRexExit of Feature
	(properties
		sel_20 {tRexExit}
		sel_1 287
		sel_0 69
		sel_213 2
		sel_6 35
		sel_7 271
		sel_8 103
		sel_9 304
	)
	
	(method (sel_300 param1)
		(switch param1
			(1
				(if (< (gEgo sel_1?) 202)
					(gLb2Messager sel_295: 2 1 1)
				else
					(gLb2Messager sel_295: 2 1 2)
				)
			)
			(27
				(if local2
					(super sel_300: param1)
				else
					(global2 sel_146: sRatsEnterRex)
				)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance floor of Feature
	(properties
		sel_20 {floor}
		sel_0 1
		sel_302 8
	)
	
	(method (sel_300 param1)
		(switch param1
			(27
				(if local2
					(super sel_300: param1)
				else
					(global2 sel_146: sRatsEatCheese)
				)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance wall of Feature
	(properties
		sel_20 {wall}
		sel_0 1
		sel_213 1
		sel_302 16
	)
)

(instance sFXRats of Sound
	(properties
		sel_20 {sFXRats}
		sel_99 1
		sel_40 733
		sel_3 -1
	)
)

(instance sFXFall of Sound
	(properties
		sel_20 {sFXFall}
		sel_99 1
		sel_40 542
	)
)

(instance sFX of Sound
	(properties
		sel_20 {sFX}
		sel_99 1
	)
)
