;;; Sierra Script 1.0 - (do not remove this comment)
(script# 730)
(include sci.sh)
(use Main)
(use LBRoom)
(use RTRandCycle)
(use PChase)
(use CueObj)
(use ForwardCounter)
(use n958)
(use Sound)
(use Jump)
(use Cycle)
(use InvI)
(use User)
(use View)
(use Obj)

(public
	rm730 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
	local9
)
(instance rm730 of LBRoom
	(properties
		sel_20 {rm730}
		sel_213 1
		sel_410 740
		sel_411 720
	)
	
	(method (sel_110)
		(global2 sel_259: (List sel_109:))
		((ScriptID 2730 0) sel_57: (global2 sel_259?))
		(gEgo sel_110: sel_585: 732 sel_299: egoActions)
		(self
			sel_408: (if ((Inv sel_64: 15) sel_4?) 730 else 780)
		)
		(if ((Inv sel_64: 15) sel_4?)
			(piece1 sel_110:)
			(piece2 sel_110:)
			(piece3 sel_110:)
			(Palette palSET_INTENSITY 0 255 0)
		)
		(proc958_0 132 732)
		(gGame sel_587:)
		(super sel_110:)
		(if (!= (gGameMusic2 sel_40?) 17)
			(gGameMusic2 sel_40: 17 sel_3: -1 sel_99: 1 sel_39:)
		)
		(gIconBar sel_233: 7)
		(steve sel_110:)
		(snake1 sel_110:)
		(snake2 sel_110:)
		(snake3 sel_110:)
		(snake4 sel_110:)
		(snake5 sel_110:)
		(floor sel_110:)
		(wall sel_110:)
		(hieroglyphics sel_110:)
		(if ((Inv sel_64: 15) sel_4?)
			(= local0 1)
			(self sel_146: sEnterSouthLight)
		else
			(self sel_146: sEnterDark)
		)
	)
	
	(method (sel_57)
		(super sel_57: &rest)
		(if
			(and
				(== (self sel_408?) 780)
				((Inv sel_64: 15) sel_4?)
			)
			(= local0 1)
			(Palette palSET_INTENSITY 0 255 0)
			(piece1 sel_110:)
			(piece2 sel_110:)
			(piece3 sel_110:)
			(self sel_408: 730 sel_417: 730)
			(gGame sel_587:)
			(gIconBar sel_233: 7)
			(sFX sel_40: 732 sel_99: 1 sel_3: -1 sel_39:)
			(gEgo
				sel_2: 732
				sel_155: 0
				sel_153: 96 161
				sel_244: 4
				sel_53: 4
				sel_51: 2
				sel_161: Walk
			)
			(steve
				sel_155: 0
				sel_153: 65 180
				sel_161: Walk
				sel_244: 4
				sel_53: 4
				sel_51: 2
				sel_312: PFollow gEgo 36
			)
			(snake1
				sel_2: 731
				sel_155: 2
				sel_156: 0
				sel_153: 248 72
				sel_244: 6
				sel_161: Fwd
			)
			(snake2
				sel_2: 731
				sel_155: 2
				sel_156: 2
				sel_153: 252 59
				sel_244: 6
				sel_161: Fwd
			)
			(snake3
				sel_2: 731
				sel_155: 2
				sel_156: 0
				sel_153: 266 62
				sel_244: 6
				sel_161: Fwd
			)
			(snake4
				sel_2: 731
				sel_155: 2
				sel_156: 2
				sel_153: 265 57
				sel_244: 6
				sel_161: Fwd
			)
			(snake5
				sel_2: 731
				sel_155: 2
				sel_156: 0
				sel_153: 276 55
				sel_244: 6
				sel_161: Fwd
			)
			(snake6 sel_244: 6 sel_161: Fwd sel_110:)
			(snake7 sel_244: 6 sel_161: Fwd sel_110:)
			(Load rsVIEW 734)
			(Load rsSOUND 3)
			(= local9 1)
		)
		(if local0
			(Palette palSET_INTENSITY 0 255 (= local2 (+ local2 2)))
			(if (>= local2 100)
				(= local0 0)
				(if (!= (global2 sel_142?) sEnterSouthLight)
					(gGame sel_588:)
					(gIconBar sel_233: 7)
				)
				(piece1 sel_317:)
				(piece2 sel_317:)
				(piece3 sel_317:)
				(if local9 (self sel_146: sLetThereBeLight))
			)
		)
		(if local1
			(Palette
				palSET_INTENSITY
				0
				255
				(proc999_3 0 (= local2 (- local2 3)))
			)
			(if (== local2 0) (= local1 0))
		)
		(cond 
			(sel_142 0)
			((proc0_1 gEgo 8) (gGame sel_587:) (= local1 1) (self sel_146: sExitEast))
		)
	)
	
	(method (sel_111)
		(proc958_0 0 930 991)
		(DisposeScript 2730)
		(super sel_111:)
	)
	
	(method (sel_300 param1)
		(switch param1
			(1
				(if (== (self sel_408?) 780)
					(gLb2Messager sel_295: 1 1 1)
				else
					(gLb2Messager sel_295: 1 1 11)
				)
			)
			(4
				(if (== (self sel_408?) 780)
					(gLb2Messager sel_295: 1 4 1)
				else
					(gLb2Messager sel_295: 1 4 11)
				)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance sEnterSouthLight of Script
	(properties
		sel_20 {sEnterSouthLight}
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
					sel_153: -10 240
					sel_349: 0
					sel_161: Walk
					sel_244: 4
					sel_53: 4
					sel_51: 2
					sel_312: MoveTo 96 161 self
				)
				(snake1
					sel_2: 731
					sel_155: 2
					sel_156: 0
					sel_153: 248 72
					sel_244: 6
					sel_161: Fwd
				)
				(snake2
					sel_2: 731
					sel_155: 2
					sel_156: 2
					sel_153: 252 59
					sel_244: 6
					sel_161: Fwd
				)
				(snake3
					sel_2: 731
					sel_155: 2
					sel_156: 0
					sel_153: 266 62
					sel_244: 6
					sel_161: Fwd
				)
				(snake4
					sel_2: 731
					sel_155: 2
					sel_156: 2
					sel_153: 265 57
					sel_244: 6
					sel_161: Fwd
				)
				(snake5
					sel_2: 731
					sel_155: 2
					sel_156: 0
					sel_153: 276 55
					sel_244: 6
					sel_161: Fwd
				)
				(snake6 sel_244: 6 sel_161: Fwd sel_110:)
				(snake7 sel_244: 6 sel_161: Fwd sel_110:)
				(Load rsVIEW 734)
				(Load rsSOUND 3)
			)
			(1
				(gGame sel_588:)
				(gIconBar sel_233: 7)
				(= sel_137 5)
			)
			(2
				(snake1 sel_155: 0 sel_161: Walk sel_312: MoveTo 58 184)
				(snake2 sel_155: 0 sel_161: Walk sel_312: MoveTo 45 180)
				(snake3 sel_155: 0 sel_161: Walk sel_312: MoveTo 59 183)
				(snake4 sel_155: 0 sel_161: Walk sel_312: MoveTo 58 178)
				(snake5 sel_155: 0 sel_161: Walk sel_312: MoveTo 69 176)
				(snake6 sel_155: 0 sel_161: Walk sel_312: MoveTo 72 170)
				(snake7 sel_155: 0 sel_161: Walk sel_312: MoveTo 73 165)
				(self sel_111:)
			)
		)
	)
)

(instance sExitEast of Script
	(properties
		sel_20 {sExitEast}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gEgo sel_312: MoveTo 335 23 self)
			)
			(1
				(global2 sel_399: (global2 sel_410?))
			)
		)
	)
)

(instance sEnterDark of Script
	(properties
		sel_20 {sEnterDark}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_588:)
				(User sel_237: 0)
				(User sel_347: 1)
				(gIconBar sel_233: 0 3 4 5 7)
				(steve sel_155: 2 sel_153: 66 148 sel_161: Blink 150)
				(gEgo
					sel_2: 733
					sel_155: 1
					sel_153: 85 135
					sel_161: Blink 150
				)
				(= sel_137 6)
			)
			(1
				(snake1 sel_161: Beg)
				(snake2 sel_161: Beg)
				(snake3 sel_161: Beg)
				(snake4 sel_161: Beg)
				(snake5 sel_161: Beg)
				(= sel_139 60)
			)
			(2
				(snake1 sel_161: Blink 200)
				(snake2 sel_161: Blink 200)
				(snake3 sel_161: Blink 200)
				(snake4 sel_161: Blink 200)
				(snake5 sel_161: Blink 200)
				(= sel_137 15)
			)
			(3
				(gGame sel_587:)
				(snake1 sel_155: 4 sel_312: MoveTo 110 127)
				(snake2 sel_155: 4 sel_312: MoveTo 123 117)
				(snake3 sel_155: 4 sel_312: MoveTo 137 127)
				(snake4 sel_155: 4 sel_312: MoveTo 134 106)
				(snake5 sel_155: 4 sel_312: MoveTo 152 118 self)
				(= sel_139 60)
			)
			(4
				(gGameMusic2 sel_167:)
				(gSel_608 sel_40: 3 sel_99: 1 sel_3: 1 sel_39:)
				(steve
					sel_155: 6
					sel_156: 0
					sel_244: 3
					sel_161: ForwardCounter 4
				)
				(gEgo
					sel_155: 5
					sel_156: 0
					sel_244: 3
					sel_161: ForwardCounter 4 self
				)
			)
			(5
				(steve sel_155: 2 sel_244: 6 sel_161: Blink 150)
				(gEgo sel_155: 1 sel_244: 6 sel_161: Blink 150)
			)
			(6
				(gEgo sel_155: 1 sel_156: 1 sel_312: JumpTo 98 148 self)
			)
			(7
				(gEgo sel_244: 18 sel_161: End self)
			)
			(8
				(snake1 sel_155: 4 sel_312: MoveTo 89 140)
				(snake2 sel_155: 4 sel_312: MoveTo 102 130)
				(snake3 sel_155: 4 sel_312: MoveTo 118 140)
				(snake4 sel_155: 4 sel_312: MoveTo 110 118)
				(snake5 sel_155: 4 sel_312: MoveTo 127 129 self)
			)
			(9
				(steve sel_155: 2 sel_156: 1 sel_312: JumpTo 77 163 self)
			)
			(10
				(steve sel_244: 18 sel_161: End self)
			)
			(11 (= sel_139 60))
			(12
				(= global145 11)
				(global2 sel_399: 99)
				(self sel_111:)
			)
		)
	)
)

(instance sLetThereBeLight of Script
	(properties
		sel_20 {sLetThereBeLight}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0 (= sel_137 7))
			(1
				(snake1 sel_155: 0 sel_161: Walk sel_312: MoveTo 58 184)
				(snake2 sel_155: 0 sel_161: Walk sel_312: MoveTo 45 180)
				(snake3 sel_155: 0 sel_161: Walk sel_312: MoveTo 59 183)
				(snake4 sel_155: 0 sel_161: Walk sel_312: MoveTo 58 178)
				(snake5 sel_155: 0 sel_161: Walk sel_312: MoveTo 69 176)
				(snake6 sel_155: 0 sel_161: Walk sel_312: MoveTo 72 170)
				(snake7 sel_155: 0 sel_161: Walk sel_312: MoveTo 73 165)
				(self sel_111:)
			)
		)
	)
)

(instance sSteveDies of Script
	(properties
		sel_20 {sSteveDies}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(steve
					sel_2: 734
					sel_155: 1
					sel_156: 0
					sel_244: 12
					sel_316: 1
					sel_161: End self
				)
			)
			(1
				(snake1 sel_161: Fwd sel_312: 0)
				(snake2 sel_161: Fwd sel_312: 0)
				(snake3 sel_161: Fwd sel_312: 0)
				(snake4 sel_161: Fwd sel_312: 0)
				(snake5 sel_161: Fwd sel_312: 0)
				(snake6 sel_161: Fwd sel_312: 0)
				(snake7 sel_161: Fwd sel_312: 0)
				(= sel_139 120)
			)
			(2
				(= global145 11)
				(global2 sel_399: 99)
				(self sel_111:)
			)
		)
	)
)

(instance sSprinkleOil of Script
	(properties
		sel_20 {sSprinkleOil}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gEgo sel_155: 1 sel_156: 0 sel_161: CT 4 1 self)
			)
			(1
				(oil
					sel_110:
					sel_153: (+ (gEgo sel_1?) 23) (- (gEgo sel_0?) 27)
					sel_312: JumpTo (+ (gEgo sel_1?) 59) (- (gEgo sel_0?) 39) self
				)
				(gEgo sel_156: 5)
			)
			(2
				(= local3 1)
				(oil sel_313:)
				(gEgo
					sel_2: 732
					sel_155: 0
					sel_244: 4
					sel_53: 4
					sel_51: 2
					sel_161: Walk
				)
				(if local8 (sRepelSnakes sel_145:))
				(self sel_111:)
			)
		)
	)
)

(instance sRepelSnakes of Script
	(properties
		sel_20 {sRepelSnakes}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(snake1 sel_161: Fwd sel_312: 0)
				(snake2 sel_161: Fwd sel_312: 0)
				(snake3 sel_161: Fwd sel_312: 0)
				(snake4 sel_161: Fwd sel_312: 0)
				(snake5 sel_161: Fwd sel_312: 0)
				(snake6 sel_161: Fwd sel_312: 0)
				(snake7 sel_161: Fwd sel_312: 0)
				(if local3
					(= sel_136 1)
				else
					(= local8 1)
					(gEgo sel_146: sSprinkleOil)
				)
			)
			(1 (= sel_139 90))
			(2
				(snake1
					sel_155: 1
					sel_153: (snake1 sel_1?) (- (snake1 sel_0?) 3)
					sel_161: Walk
					sel_312: MoveTo 320 27 self
				)
				(snake2
					sel_155: 1
					sel_153: (snake2 sel_1?) (- (snake2 sel_0?) 3)
					sel_161: Walk
					sel_312: MoveTo 324 14
				)
				(snake3
					sel_155: 1
					sel_153: (snake3 sel_1?) (- (snake3 sel_0?) 3)
					sel_161: Walk
					sel_312: MoveTo 338 17
				)
				(snake4
					sel_155: 1
					sel_153: (snake4 sel_1?) (- (snake4 sel_0?) 3)
					sel_161: Walk
					sel_312: MoveTo 337 12
				)
				(snake5
					sel_155: 1
					sel_153: (snake5 sel_1?) (- (snake5 sel_0?) 3)
					sel_161: Walk
					sel_312: MoveTo 348 10
				)
				(snake6
					sel_155: 1
					sel_153: (snake6 sel_1?) (- (snake6 sel_0?) 3)
					sel_161: Walk
					sel_312: MoveTo 351 4
				)
				(snake7
					sel_155: 1
					sel_153: (snake7 sel_1?) (- (snake7 sel_0?) 3)
					sel_161: Walk
					sel_312: MoveTo 352 -1
				)
			)
			(3
				(snake1 sel_111:)
				(snake2 sel_111:)
				(snake3 sel_111:)
				(snake4 sel_111:)
				(snake5 sel_111:)
				(snake6 sel_111:)
				(snake7 sel_111:)
				(sFX sel_167:)
				(= local4 1)
				(gGame sel_588:)
				(gIconBar sel_233: 7)
				(self sel_111:)
			)
		)
	)
)

(instance sThrowBottle of Script
	(properties
		sel_20 {sThrowBottle}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gEgo sel_155: 1 sel_156: 0 sel_161: CT 4 1 self)
			)
			(1
				(oilBottle
					sel_110:
					sel_161: Fwd
					sel_153: (+ (gEgo sel_1?) 23) (- (gEgo sel_0?) 27)
					sel_312: JumpTo (+ (gEgo sel_1?) 59) (- (gEgo sel_0?) 39) self
				)
				(gEgo sel_156: 5)
			)
			(2
				(oilBottle sel_155: 4 sel_156: 0 sel_161: End self)
			)
			(3
				(oilBottle sel_161: 0 sel_317:)
				(gEgo
					sel_2: 732
					sel_155: 0
					sel_351: 14
					sel_244: 4
					sel_53: 4
					sel_51: 2
					sel_161: Walk
				)
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
			(1
				(if (== (global2 sel_408?) 780)
					(gLb2Messager sel_295: 3 1 1)
				else
					0
				)
			)
			(25
				(gLb2Messager sel_295: 11 25)
			)
			(else  0)
		)
	)
)

(instance steve of Actor
	(properties
		sel_20 {steve}
		sel_1 -30
		sel_0 260
		sel_213 9
		sel_2 733
	)
	
	(method (sel_300 param1)
		(switch param1
			(1
				(if (== (global2 sel_408?) 780)
					(gLb2Messager sel_295: 4 1 1)
				else
					(gLb2Messager sel_295: 1 1 27 0 0 1887)
				)
			)
			(4
				(if (== (global2 sel_408?) 780)
					(super sel_300: param1)
				else
					(gLb2Messager sel_295: 1 4 27 0 0 1887)
				)
			)
			(8
				(if (== (global2 sel_408?) 780)
					(super sel_300: param1)
				else
					(gLb2Messager sel_295: 1 8 27 0 0 1887)
				)
			)
			(2
				(if local4
					(gLb2Messager sel_295: 9 2 9)
				else
					(switch local7
						(0
							(gLb2Messager sel_295: 9 2 5)
						)
						(else 
							(gLb2Messager sel_295: 9 2 6)
						)
					)
					(++ local7)
				)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance snake1 of Actor
	(properties
		sel_20 {snake1}
		sel_1 226
		sel_0 60
		sel_213 7
		sel_2 733
		sel_3 4
		sel_4 3
		sel_14 16384
	)
	
	(method (sel_57)
		(super sel_57: &rest)
		(cond 
			(sel_142)
			((== (global2 sel_142?) sRepelSnakes))
			((and local3 (< (gEgo sel_255: snake1) 65)) (global2 sel_146: sRepelSnakes))
			(
				(and
					(< (self sel_255: gEgo) 14)
					(== (gEgo sel_2?) 732)
					(== (self sel_2?) 731)
				)
				(gGame sel_587:)
				(gGameMusic2 sel_167:)
				(gSel_608 sel_40: 3 sel_99: 1 sel_3: 1 sel_39:)
				(gEgo
					sel_2: 734
					sel_155: 0
					sel_156: 0
					sel_244: 12
					sel_161: End
				)
			)
			(
				(and
					(< (self sel_255: steve) 14)
					(== (steve sel_2?) 733)
					(== (self sel_2?) 731)
				)
				(global2 sel_146: sSteveDies)
			)
		)
	)
	
	(method (sel_300 param1)
		(switch param1
			(1
				(if (== (global2 sel_408?) 780)
					(gLb2Messager sel_295: 5 1 1)
				else
					(switch local5
						(0
							(gLb2Messager sel_295: 7 1 2)
						)
						(1
							(gLb2Messager sel_295: 7 1 3)
						)
						(else 
							(gLb2Messager sel_295: 7 1 4)
						)
					)
					(++ local5)
				)
			)
			(2
				(switch local6
					(0
						(gLb2Messager sel_295: 7 2 5)
					)
					(else 
						(gLb2Messager sel_295: 7 2 6)
					)
				)
				(++ local6)
			)
			(25
				(cond 
					((== (global2 sel_408?) 780) 0)
					((== global150 0) (gEgo sel_146: sThrowBottle))
					((< (gEgo sel_255: snake1) 65) (global2 sel_146: sRepelSnakes))
					(else (gGame sel_587:) (gEgo sel_146: sSprinkleOil))
				)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance snake2 of Actor
	(properties
		sel_20 {snake2}
		sel_1 240
		sel_0 51
		sel_213 7
		sel_2 733
		sel_3 4
		sel_4 3
		sel_14 16384
	)
	
	(method (sel_300)
		(snake1 sel_300: &rest)
	)
)

(instance snake3 of Actor
	(properties
		sel_20 {snake3}
		sel_1 256
		sel_0 57
		sel_213 7
		sel_2 733
		sel_3 4
		sel_4 3
		sel_14 16384
	)
	
	(method (sel_300)
		(snake1 sel_300: &rest)
	)
)

(instance snake4 of Actor
	(properties
		sel_20 {snake4}
		sel_1 248
		sel_0 40
		sel_213 7
		sel_2 733
		sel_3 4
		sel_4 3
		sel_14 16384
	)
	
	(method (sel_300)
		(snake1 sel_300: &rest)
	)
)

(instance snake5 of Actor
	(properties
		sel_20 {snake5}
		sel_1 271
		sel_0 49
		sel_213 7
		sel_2 733
		sel_3 4
		sel_4 3
		sel_14 16384
	)
	
	(method (sel_300)
		(snake1 sel_300: &rest)
	)
)

(instance snake6 of Actor
	(properties
		sel_20 {snake6}
		sel_1 279
		sel_0 49
		sel_213 7
		sel_2 731
		sel_3 2
		sel_14 16384
	)
	
	(method (sel_300)
		(snake1 sel_300: &rest)
	)
)

(instance snake7 of Actor
	(properties
		sel_20 {snake7}
		sel_1 280
		sel_0 44
		sel_213 7
		sel_2 731
		sel_3 2
		sel_4 2
		sel_14 16384
	)
	
	(method (sel_300)
		(snake1 sel_300: &rest)
	)
)

(instance oil of Actor
	(properties
		sel_20 {oil}
		sel_2 732
		sel_3 2
		sel_60 2
		sel_14 16400
	)
	
	(method (sel_300 param1)
		(switch param1
			(1
				(gLb2Messager sel_295: 10 1 10)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance oilBottle of Actor
	(properties
		sel_20 {oilBottle}
		sel_2 732
		sel_3 3
		sel_14 16384
	)
)

(instance piece1 of View
	(properties
		sel_20 {piece1}
		sel_1 37
		sel_0 126
		sel_2 731
		sel_3 3
		sel_60 1
		sel_14 16401
	)
	
	(method (sel_218)
		(return 0)
	)
)

(instance piece2 of View
	(properties
		sel_20 {piece2}
		sel_1 115
		sel_0 74
		sel_2 731
		sel_3 3
		sel_4 1
		sel_60 1
		sel_14 16401
	)
	
	(method (sel_218)
		(return 0)
	)
)

(instance piece3 of View
	(properties
		sel_20 {piece3}
		sel_1 207
		sel_0 46
		sel_2 731
		sel_3 3
		sel_4 2
		sel_60 1
		sel_14 16401
	)
	
	(method (sel_218)
		(return 0)
	)
)

(instance floor of Feature
	(properties
		sel_20 {floor}
		sel_0 1
		sel_213 10
		sel_302 4
	)
	
	(method (sel_300 param1)
		(asm
			lsp      param1
			dup     
			ldi      25
			eq?     
			bnt      code_15aa
			lal      local4
			bnt      code_153b
			ldi      0
			jmp      code_15b3
code_153b:
			lsg      gSel_1
			pushi    #sel_1
			pushi    0
			lag      gEgo
			send     4
			gt?     
			bnt      code_1599
			jmp      code_1549
code_1549:
			bnt      code_1599
			lsg      global150
			ldi      0
			eq?     
			bnt      code_1562
			pushi    #sel_146
			pushi    1
			lofsa    sThrowBottle
			push    
			lag      gEgo
			send     6
			jmp      code_15b3
code_1562:
			pushi    #sel_255
			pushi    1
			lofsa    snake1
			push    
			lag      gEgo
			send     6
			push    
			ldi      65
			lt?     
			bnt      code_1583
			pushi    #sel_146
			pushi    1
			lofsa    sRepelSnakes
			push    
			lag      global2
			send     6
			jmp      code_15b3
code_1583:
			pushi    #sel_587
			pushi    0
			lag      gGame
			send     4
			pushi    #sel_146
			pushi    1
			lofsa    sSprinkleOil
			push    
			lag      gEgo
			send     6
			jmp      code_15b3
code_1599:
			pushi    #sel_295
			pushi    3
			pushi    10
			pushi    25
			pushi    8
			lag      gLb2Messager
			send     10
			jmp      code_15b3
code_15aa:
			pushi    #sel_300
			pushi    1
			lsp      param1
			super    Feature,  6
code_15b3:
			toss    
			ret     
		)
	)
)

(instance hieroglyphics of Feature
	(properties
		sel_20 {hieroglyphics}
		sel_0 1
		sel_213 2
		sel_302 2
	)
)

(instance wall of Feature
	(properties
		sel_20 {wall}
		sel_0 1
		sel_213 6
		sel_302 16
	)
)

(instance sFX of Sound
	(properties
		sel_20 {sFX}
		sel_99 1
	)
)
