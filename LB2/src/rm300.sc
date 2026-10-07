;;; Sierra Script 1.0 - (do not remove this comment)
(script# 300)
(include sci.sh)
(use Main)
(use Door)
(use LBRoom)
(use ExitFeature)
(use Print)
(use RTRandCycle)
(use Scaler)
(use PolyPath)
(use Polygon)
(use CueObj)
(use n958)
(use Sound)
(use Cycle)
(use View)
(use Obj)

(public
	rm300 0
	Bouncer 17
)

(local
	local0
	local1
	gEgoSel_53
)
(instance rm300 of LBRoom
	(properties
		sel_20 {rm300}
		sel_213 20
		sel_408 300
		sel_409 310
		sel_411 260
		sel_107 167
	)
	
	(method (sel_110)
		(proc958_0 128 303 301 852 304 284)
		(proc958_0 132 94 40)
		(self sel_414: 91)
		(gEgo
			sel_110:
			sel_585: (if (gEgo sel_584?) 831 else 830)
			sel_320: Scaler 90 110 167 125
		)
		(switch gGSel_40
			(sel_409
				(gEgo sel_349: 0 sel_253: 180)
				(gSel_608 sel_170:)
			)
			(sel_411
				(gEgo sel_1: 230 sel_0: 200)
				(global2 sel_146: sOverControl)
			)
			(else 
				(taxi sel_320: 199 sel_110: sel_153: 269 199)
				(global2 sel_146: sOutCab)
			)
		)
		(super sel_110:)
		(self
			sel_395:
				((Polygon sel_109:)
					sel_31: 2
					sel_110: 291 165 298 175 277 179 244 177 242 169
					sel_117:
				)
				((Polygon sel_109:)
					sel_31: 2
					sel_110:
						0
						0
						319
						0
						319
						158
						165
						168
						127
						168
						97
						161
						98
						155
						127
						146
						123
						121
						95
						141
						84
						156
						11
						185
						122
						185
						122
						178
						161
						178
						161
						185
						231
						185
						232
						189
						0
						189
					sel_117:
				)
		)
		(mugger sel_110: sel_146: sMugTimer)
		(frontDoor sel_110: sel_311: 11 6 4)
		(taxiSign sel_311: 4 sel_317:)
		(fireHydrant sel_110:)
		(trash sel_110:)
		(flowersDoor sel_110:)
		(flowerWinL sel_110:)
		(flowerWinR sel_110:)
		(tinyWin sel_110:)
		(moxieSign sel_110:)
		(streetLight sel_110:)
		(southExitFeature sel_110:)
	)
	
	(method (sel_399 param1)
		(if (== param1 310) (gSel_608 sel_170:))
		(super sel_399: param1)
	)
)

(instance sOverControl of Script
	(properties
		sel_20 {sOverControl}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(gEgo sel_312: PolyPath (gEgo sel_1?) 170 self)
			)
			(1
				(gGame sel_588:)
				(self sel_111:)
			)
		)
	)
)

(instance sOutCab of Script
	(properties
		sel_20 {sOutCab}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(gEgo sel_1: 241 sel_0: 179)
				(= sel_137 1)
			)
			(1
				(gGameMusic2 sel_173: 2 224 2000)
				(taxi sel_155: 5 sel_312: MoveTo 157 275 self)
				(gGameMusic2 sel_170:)
			)
			(2
				(gGame sel_588:)
				(taxi sel_111:)
				(self sel_111:)
			)
		)
	)
)

(instance sMugTimer of Script
	(properties
		sel_20 {sMugTimer}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(if (gEgo sel_584?)
					(self sel_111:)
				else
					(= sel_137 240)
				)
			)
			(1
				(sel_42 sel_146: sMuggerKills)
			)
		)
	)
)

(instance sMuggerKills of Script
	(properties
		sel_20 {sMuggerKills}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0 (= sel_137 1))
			(1
				(if (global2 sel_142?)
					(self sel_111:)
				else
					(gGame sel_587:)
					(= sel_136 1)
				)
			)
			(2
				(cond 
					((proc0_1 gEgo 2) (gEgo sel_312: PolyPath 101 169 self))
					((> (gEgo sel_1?) 300) (gEgo sel_312: PolyPath 280 165 self))
					(else (= sel_136 1))
				)
			)
			(3
				(proc0_5 gEgo mugger)
				(noise sel_40: 163 sel_3: -1 sel_99: 1 sel_39:)
				(= sel_136 5)
			)
			(4
				(mugger
					sel_2: 303
					sel_155: 0
					sel_63: -1
					sel_244: 4
					sel_53: 4
					sel_161: Walk
					sel_312: MoveTo 311 162 self
				)
			)
			(5
				(mugger
					sel_312: PolyPath (+ (gEgo sel_1?) 22) (+ (gEgo sel_0?) 3) self
				)
			)
			(6
				(mugger
					sel_155: 1
					sel_4: 0
					sel_153: (- (mugger sel_1?) 5) (- (mugger sel_0?) 1)
					sel_244: 12
					sel_53: 12
					sel_161: End self
				)
				(noise sel_167:)
				(sFX sel_40: 3 sel_39:)
			)
			(7 (= sel_137 1))
			(8
				(gEgo
					sel_2: 303
					sel_3: 2
					sel_153: (gEgo sel_1?) (- (gEgo sel_0?) 3)
					sel_244: 12
					sel_53: 12
					sel_161: End self
				)
			)
			(9
				(gLb2Messager sel_295: 1 0 0 0 self)
				(gEgo sel_59: 0)
			)
			(10
				(= global145 12)
				(global2 sel_399: 99)
			)
		)
	)
)

(instance sGivePass of Script
	(properties
		sel_20 {sGivePass}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(= sel_136 1)
			)
			(1 (= sel_137 1))
			(2
				(gEgo sel_351: 6)
				(gEgo
					sel_2: 301
					sel_3: 0
					sel_153: 88 160
					sel_244: 10
					sel_53: 10
					sel_161: End self
				)
			)
			(3
				(gLb2Messager sel_295: 3 11 0 0 self)
			)
			(4
				(gEgo
					sel_153: 79 159
					sel_585: (if (gEgo sel_584?) 831 else 830)
				)
				(= sel_136 1)
			)
			(5
				(gGame sel_588:)
				(if (mugger sel_142?) ((mugger sel_142?) sel_111:))
				(gGame sel_587:)
				(mugger sel_146: sMuggerKills)
				(self sel_111:)
			)
		)
	)
)

(instance sHailCab of Script
	(properties
		sel_20 {sHailCab}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGameMusic2 sel_40: 252 sel_3: -1 sel_99: 1 sel_39: 20)
				(gGame sel_587:)
				(= sel_136 1)
			)
			(1
				(taxi sel_110: sel_320: 199 sel_153: 415 186)
				(gEgo sel_312: PolyPath 242 179 self)
			)
			(2
				(gEgo
					sel_2: (if (gEgo sel_584?) 304 else 852)
					sel_155: (if (gEgo sel_584?) 2 else 0)
					sel_153: (- (gEgo sel_1?) 2) (- (gEgo sel_0?) 1)
					sel_320: Scaler 105 0 190 0
					sel_161: End self
				)
				(gSel_608 sel_40: 97 sel_3: 1 sel_99: 1 sel_39:)
			)
			(3
				(gGameMusic2 sel_173: 2 224 2000 sel_170: 127 5 5 0)
				(taxi
					sel_155: 5
					sel_312: MoveTo (+ (taxiSign sel_1?) 10) (+ (taxiSign sel_0?) 25) self
				)
			)
			(4
				(gGameMusic2 sel_173: 2 224 1600)
				(= sel_136 1)
			)
			(5
				(gGameMusic2 sel_173: 2 224 1200)
				(= sel_136 1)
			)
			(6
				(gGameMusic2 sel_173: 2 224 800)
				(= sel_136 1)
			)
			(7
				(gGameMusic2 sel_173: 2 224 400)
				(= sel_136 1)
			)
			(8
				(gGameMusic2 sel_173: 2 224 0)
				(noise sel_40: 40 sel_99: 5 sel_39: self)
			)
			(9
				(gEgo sel_585: 830 sel_102:)
				(= sel_136 1)
			)
			(10 (global2 sel_399: 250))
		)
	)
)

(instance sEnterBar of Script
	(properties
		sel_20 {sEnterBar}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(= gEgoSel_53 (gEgo sel_53?))
				(= sel_136 1)
			)
			(1
				(gEgo
					sel_2: 301
					sel_3: 0
					sel_4: 0
					sel_153: (+ (gEgo sel_1?) 10) (gEgo sel_0?)
					sel_352: 6
					sel_161: CT 5 1 self
				)
			)
			(2
				(sFX sel_40: 297 sel_39:)
				(gEgo sel_161: CT 6 1 self)
			)
			(3 (gEgo sel_161: CT 2 -1 self))
			(4 (gEgo sel_161: CT 5 1 self))
			(5 (gEgo sel_161: CT 6 1 self))
			(6
				(gEgo
					sel_3: 6
					sel_153: (- (gEgo sel_1?) 10) (gEgo sel_0?)
					sel_352: gEgoSel_53
					sel_585: (if (gEgo sel_584?) 831 else 830)
				)
				(= sel_136 5)
			)
			(7
				(gLb2Messager sel_295: 3 4 0 1 self)
			)
			(8
				(switch
					(Print
						sel_198: 2 0 0 0
						sel_205: 1 14 0 0 1 5 20
						sel_205: 2 14 0 0 2 5 38
						sel_205: 3 14 0 0 3 5 56
						sel_110:
					)
					(1 (= sel_136 1))
					(2
						(gLb2Messager sel_295: 3 4 0 5 self)
					)
					(3
						(= local0 1)
						(gLb2Messager sel_295: 3 4 0 6 self)
					)
					(else  (= sel_136 1))
				)
			)
			(9 (= sel_136 1))
			(10
				(if local0
					(sel_42 sel_146: sAskEnterBar)
				else
					(gGame sel_588:)
					(self sel_111:)
				)
			)
		)
	)
)

(instance sAskEnterBar of Script
	(properties
		sel_20 {sAskEnterBar}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(= sel_141 0)
				(if local0
					(switch (global2 sel_422: (ScriptID 20 0))
						(1029
							(gLb2Messager sel_295: 3 4 0 7 self)
							(= sel_141 1)
						)
						(else 
							(gLb2Messager sel_295: 3 4 0 8 self)
							(= local0 0)
						)
					)
				else
					(gLb2Messager sel_295: 3 4 0 8 self)
					(= local0 0)
				)
			)
			(1
				(if (== sel_141 1)
					(gLb2Messager sel_295: 3 4 0 9 self)
				else
					(= sel_136 1)
				)
			)
			(2
				(if (== sel_141 1)
					(= local1 1)
					(= global116 1024)
					(= gGUserSel_237 (= gGUserSel_347 1))
					(frontDoor sel_300: 4)
				else
					(gGame sel_588:)
				)
				(self sel_111:)
			)
		)
	)
)

(instance mugger of Actor
	(properties
		sel_20 {mugger}
		sel_1 330
		sel_0 160
		sel_213 1
		sel_2 303
	)
)

(instance frontDoor of Door
	(properties
		sel_20 {frontDoor}
		sel_1 104
		sel_0 155
		sel_213 3
		sel_303 79
		sel_304 159
		sel_2 304
		sel_589 310
		sel_597 121
		sel_598 143
		sel_599 0
		sel_600 0
	)
	
	(method (sel_300 param1)
		(switch param1
			(4
				(if local1
					(super sel_300: param1 &rest)
				else
					(global2 sel_146: sEnterBar)
				)
			)
			(11
				(global2 sel_146: sGivePass)
			)
			(6
				(if local0
					(gGame sel_587:)
					(global2 sel_146: sAskEnterBar)
				else
					(global2 sel_146: sEnterBar)
				)
			)
			(14
				(if local0
					(gGame sel_587:)
					(global2 sel_146: sAskEnterBar)
				else
					(global2 sel_146: sEnterBar)
				)
			)
			(else 
				(super sel_300: param1 &rest)
			)
		)
	)
	
	(method (sel_145)
		(super sel_145: &rest)
		(if (gEgo sel_584?) (global2 sel_146: sHailCab))
	)
	
	(method (sel_606)
		(super sel_606: 77 146 109 148 109 157 77 154)
	)
)

(instance taxi of Actor
	(properties
		sel_20 {taxi}
		sel_1 415
		sel_0 186
		sel_213 8
		sel_2 852
		sel_3 5
		sel_53 4
	)
)

(instance taxiSign of View
	(properties
		sel_20 {taxiSign}
		sel_1 259
		sel_0 174
		sel_213 9
		sel_301 40
		sel_303 242
		sel_304 179
		sel_2 284
		sel_4 1
		sel_14 16384
	)
	
	(method (sel_300 param1)
		(switch param1
			(4 (global2 sel_146: sHailCab))
			(else 
				(super sel_300: param1 &rest)
			)
		)
	)
)

(instance fireHydrant of Feature
	(properties
		sel_20 {fireHydrant}
		sel_1 142
		sel_0 169
		sel_213 10
		sel_6 153
		sel_7 136
		sel_8 185
		sel_9 148
		sel_301 40
	)
)

(instance trash of Feature
	(properties
		sel_20 {trash}
		sel_1 33
		sel_0 143
		sel_213 11
		sel_6 133
		sel_7 13
		sel_8 154
		sel_9 54
		sel_301 40
	)
)

(instance flowersDoor of Feature
	(properties
		sel_20 {flowersDoor}
		sel_1 185
		sel_0 125
		sel_213 5
		sel_6 98
		sel_7 171
		sel_8 152
		sel_9 199
		sel_301 40
	)
)

(instance flowerWinL of Feature
	(properties
		sel_20 {flowerWinL}
		sel_1 152
		sel_0 122
		sel_213 6
		sel_6 98
		sel_7 135
		sel_8 147
		sel_9 169
		sel_301 40
	)
)

(instance flowerWinR of Feature
	(properties
		sel_20 {flowerWinR}
		sel_1 225
		sel_0 121
		sel_213 6
		sel_6 98
		sel_7 200
		sel_8 144
		sel_9 251
		sel_301 40
	)
)

(instance tinyWin of Feature
	(properties
		sel_20 {tinyWin}
		sel_1 91
		sel_0 109
		sel_213 4
		sel_6 106
		sel_7 88
		sel_8 112
		sel_9 95
		sel_301 40
	)
)

(instance moxieSign of Feature
	(properties
		sel_20 {moxieSign}
		sel_1 34
		sel_0 78
		sel_213 7
		sel_6 60
		sel_8 97
		sel_9 69
		sel_301 40
	)
)

(instance streetLight of Feature
	(properties
		sel_20 {streetLight}
		sel_1 275
		sel_0 78
		sel_213 12
		sel_302 16384
	)
)

(instance southExitFeature of ExitFeature
	(properties
		sel_20 {southExitFeature}
		sel_6 184
		sel_7 219
		sel_8 189
		sel_9 289
		sel_33 11
		sel_583 3
		sel_213 15
	)
)

(instance Bouncer of Narrator
	(properties
		sel_20 {Bouncer}
		sel_1 100
		sel_0 50
		sel_537 150
		sel_26 15
	)
	
	(method (sel_110)
		(= sel_30 gSel_30)
		(super sel_110: &rest)
	)
)

(instance noise of Sound
	(properties
		sel_20 {noise}
		sel_99 1
	)
)

(instance sFX of Sound
	(properties
		sel_20 {sFX}
		sel_99 1
	)
)
