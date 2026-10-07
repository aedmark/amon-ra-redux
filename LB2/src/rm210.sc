;;; Sierra Script 1.0 - (do not remove this comment)
(script# 210)
(include sci.sh)
(use Main)
(use Door)
(use LBRoom)
(use ExitFeature)
(use Inset)
(use Scaler)
(use PolyPath)
(use Polygon)
(use CueObj)
(use n958)
(use Path)
(use Sound)
(use Cycle)
(use View)
(use Obj)

(public
	rm210 0
)

(local
	[local0 5] = [140 165 350 165 -32768]
	[local5 5] = [150 167 519 167 -32768]
	[local10 5] = [127 172 370 172 -32768]
)
(instance rm210 of LBRoom
	(properties
		sel_20 {rm210}
		sel_213 16
		sel_408 210
		sel_409 230
		sel_411 280
		sel_107 150
		sel_108 112
	)
	
	(method (sel_110)
		(proc958_0 128 214 210 284 212 213 852 803)
		(proc958_0 132 190 40 252)
		(self sel_414: 91)
		(gEgo sel_585: 803 sel_110:)
		(switch gGSel_40
			(sel_409
				(gEgo sel_349: 0 sel_253: 180 sel_320: 0 sel_585: 803)
			)
			(sel_411
				(global2 sel_146: sOverControl)
			)
			(else 
				(gEgo sel_1: 150 sel_0: 187)
				(taxi
					sel_320: Scaler 105 0 190 112
					sel_110:
					sel_153: 190 195
				)
				(global2 sel_146: sOutCab)
			)
		)
		(super sel_110:)
		(self
			sel_395:
				((Polygon sel_109:)
					sel_31: 2
					sel_110:
						319
						0
						319
						176
						199
						176
						88
						184
						80
						183
						73
						180
						48
						174
						39
						173
						32
						165
						11
						152
						6
						167
						25
						170
						31
						180
						0
						180
						0
						0
					sel_117:
				)
				((Polygon sel_109:)
					sel_31: 2
					sel_110: 0 189 0 187 154 187 154 182 177 182 177 187 194 187 194 189
					sel_117:
				)
		)
		(if (gEgo sel_238: 0)
			(self
				sel_395:
					((Polygon sel_109:)
						sel_31: 2
						sel_110: 224 177 235 182 216 185 205 179
						sel_117:
					)
			)
			(luigi sel_311: 4 2 6 10 sel_110: sel_161: Fwd)
			(gSel_608 sel_40: 190 sel_3: -1 sel_99: 1 sel_39:)
		)
		(frontDoor sel_110:)
		(taxiSign sel_311: 4 sel_317:)
		(if (> (gGame sel_321:) 2)
			(man1
				sel_110:
				sel_155: 0
				sel_161: Walk
				sel_312: MoveTo 198 176 man1
			)
			(person2
				sel_110:
				sel_155: 2
				sel_338: 1 1
				sel_161: Walk
				sel_312: MoveTo -20 183 person2
			)
			(person3
				sel_110:
				sel_155: 3
				sel_338: 1 1
				sel_161: Walk
				sel_312: MoveTo 208 179 person3
			)
			(person4
				sel_110:
				sel_155: 5
				sel_161: Walk
				sel_312: person4Path person4
			)
		)
		(person6
			sel_110:
			sel_155: 7
			sel_338: 2 2
			sel_161: Walk
			sel_312: person6Path person6
		)
		(person8
			sel_110:
			sel_155: 11
			sel_161: Walk
			sel_312: MoveTo 202 176 person8
		)
		(car2
			sel_110:
			sel_155: 6
			sel_4: (Random 0 4)
			sel_53: 4
			sel_312: car2Path car2
		)
		(greyBuilding sel_110:)
		(nextBuilding sel_110:)
		(gothicEntrance sel_110:)
		(newsBuilding sel_110:)
		(tree sel_110:)
		(southExitFeature sel_110:)
	)
	
	(method (sel_111)
		(gSel_608 sel_170:)
		(DisposeScript 983)
		(super sel_111:)
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
				(gEgo sel_1: 134 sel_0: 185)
				(= sel_136 1)
			)
			(1
				(gEgo sel_312: PolyPath 134 180 self)
			)
			(2
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
				(= sel_136 1)
			)
			(1
				((ScriptID 91 1) sel_168:)
				(gGameMusic2 sel_173: 2 224 2000)
				(gEgo sel_153: 147 185)
				(taxi sel_155: 4 sel_312: MoveTo 105 227 self)
				(gGameMusic2 sel_170:)
			)
			(2
				((ScriptID 91 1) sel_168: 0)
				(gGame sel_588:)
				(taxi sel_111:)
				(self sel_111:)
			)
		)
	)
)

(instance sMoveMan1 of Script
	(properties
		sel_20 {sMoveMan1}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(man1
					sel_155: 1
					sel_153: 194 175
					sel_312: MoveTo 163 173 self
				)
			)
			(1 (= sel_137 (Random 3 12)))
			(2
				(man1
					sel_153: -10 188
					sel_155: 0
					sel_161: Walk
					sel_312: MoveTo 198 176 self
				)
			)
			(3 (= sel_29 -1) (= sel_136 1))
		)
	)
)

(instance sMovePerson2 of Script
	(properties
		sel_20 {sMovePerson2}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0 (= sel_137 (Random 5 10)))
			(1
				(person2
					sel_155: 8
					sel_338: 2 2
					sel_153: 166 172
					sel_312: MoveTo 194 176 self
				)
			)
			(2
				(person2 sel_3: 9 sel_312: MoveTo -20 189 self)
			)
			(3 (= sel_29 -1) (= sel_136 1))
		)
	)
)

(instance sMovePerson3 of Script
	(properties
		sel_20 {sMovePerson3}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(person3
					sel_3: 4
					sel_153: 209 176
					sel_312: MoveTo 170 172 self
				)
			)
			(1 (= sel_137 (Random 1 6)))
			(2
				(person3
					sel_3: 3
					sel_153: -10 185
					sel_312: MoveTo 208 176 self
				)
			)
			(3 (= sel_29 -1) (= sel_136 1))
		)
	)
)

(instance sMovePerson8 of Script
	(properties
		sel_20 {sMovePerson8}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(person8
					sel_3: 12
					sel_153: 203 175
					sel_312: MoveTo 158 173 self
				)
			)
			(1 (= sel_137 (Random 5 10)))
			(2
				(person8
					sel_153: -5 189
					sel_3: 11
					sel_312: MoveTo 202 176 self
				)
			)
			(3 (= sel_29 -1) (= sel_136 1))
		)
	)
)

(instance sHailTaxi of Script
	(properties
		sel_20 {sHailTaxi}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGameMusic2 sel_40: 252 sel_3: -1 sel_99: 1 sel_39: 20)
				(gGame sel_587:)
				((ScriptID 91 1) sel_168:)
				(= sel_136 1)
			)
			(1
				(gEgo
					sel_2: 852
					sel_3: 1
					sel_153: (- (gEgo sel_1?) 2) (- (gEgo sel_0?) 1)
					sel_320: Scaler 102 0 190 112
					sel_161: End self
				)
				(noise sel_40: 97 sel_39:)
			)
			(2
				(taxi
					sel_110:
					sel_320: Scaler 116 0 190 112
					sel_153: 378 181
				)
				(gGameMusic2 sel_173: 2 224 2000 sel_170: 127 5 5 0)
				(= sel_136 1)
			)
			(3
				(taxi
					sel_155: 4
					sel_51: 4
					sel_312: MoveTo (+ (taxiSign sel_1?) 25) (+ (taxiSign sel_0?) 10) self
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
				(if (gSel_561 sel_122: luigi)
					(luigi sel_146: 0 sel_317:)
				)
			)
			(9
				(gEgo
					sel_2: 803
					sel_155: 4
					sel_312: MoveTo (+ (gEgo sel_1?) 17) (gEgo sel_0?) self
				)
			)
			(10 (global2 sel_399: 250))
		)
	)
)

(instance sGetSandwich of Script
	(properties
		sel_20 {sGetSandwich}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(= sel_136 1)
			)
			(1
				(gLb2Messager sel_295: 3 10 0 1 self)
				(luigi sel_153: 221 179 sel_161: 0)
			)
			(2
				(gLb2Messager sel_295: 3 10 0 2 self)
			)
			(3
				(luigi
					sel_3: 1
					sel_153: 217 180
					sel_244: 10
					sel_161: End self
				)
			)
			(4
				(gLb2Messager sel_295: 3 10 0 3 self)
			)
			(5
				(global2 sel_422: sandwichI self)
			)
			(6
				(luigi sel_3: 0 sel_153: 221 179 sel_161: Fwd)
				(gGame sel_588:)
				(self sel_111:)
			)
		)
	)
)

(instance sGetSandwichInset of Script
	(properties
		sel_20 {sGetSandwichInset}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gEgo sel_351: 0)
				((ScriptID 21 1) sel_57: 769)
				((ScriptID 21 0) sel_57: 772)
				(sandwichI sel_111:)
				(luigi sel_3: 0 sel_153: 217 180 sel_161: Fwd)
				(= sel_136 2)
			)
			(1
				(gEgo sel_350: 3)
				(self sel_111:)
			)
		)
	)
)

(instance luigi of Prop
	(properties
		sel_20 {luigi}
		sel_1 221
		sel_0 179
		sel_213 3
		sel_303 189
		sel_304 181
		sel_2 214
		sel_14 16384
	)
	
	(method (sel_110)
		(cart
			sel_153: (- (self sel_1?) 13) (+ (self sel_0?) 5)
			sel_110:
			sel_313:
		)
		(super sel_110:)
	)
	
	(method (sel_111)
		(cart sel_111:)
		(super sel_111:)
	)
	
	(method (sel_300 param1 &tmp temp0)
		(switch param1
			(10
				(global2 sel_146: sGetSandwich)
			)
			(2
				(cond 
					(
					(and (not (gEgo sel_238: 0)) (not (proc0_2 28))) (proc0_3 28) (gLb2Messager sel_295: 3 2 1 0))
					((not (gEgo sel_238: 0)) (gLb2Messager sel_295: 3 2 2 0))
					((gEgo sel_238: 0) (gLb2Messager sel_295: 3 2 3 0))
				)
			)
			(6
				(cond 
					(
						(and
							(<= 256 (= temp0 (global2 sel_422: (ScriptID 20 0))))
							(<= temp0 409)
						)
						(gLb2Messager sel_295: 3 6 4)
					)
					((and (<= 512 temp0) (<= temp0 665)) (gLb2Messager sel_295: 3 6 5))
					((== temp0 772) (gLb2Messager sel_295: 3 6 8))
					((and (<= 768 temp0) (<= temp0 921)) (gLb2Messager sel_295: 3 6 6))
					((and (<= 1024 temp0) (<= temp0 1177)) (gLb2Messager sel_295: 3 6 7))
				)
			)
			(else 
				(super sel_300: param1 &rest)
			)
		)
	)
)

(instance cart of View
	(properties
		sel_20 {cart}
		sel_213 4
		sel_2 214
		sel_3 3
		sel_14 16385
	)
)

(instance sandwichI of Inset
	(properties
		sel_20 {sandwichI}
		sel_2 214
		sel_3 4
		sel_1 141
		sel_0 90
		sel_570 1
		sel_213 2
	)
	
	(method (sel_110)
		(super sel_110: &rest)
		(gGame sel_588:)
	)
	
	(method (sel_300 param1)
		(switch param1
			(4
				(global2 sel_146: sGetSandwichInset)
			)
			(else 
				(super sel_300: param1 &rest)
			)
		)
	)
)

(instance frontDoor of Door
	(properties
		sel_20 {frontDoor}
		sel_1 39
		sel_0 167
		sel_213 5
		sel_303 36
		sel_304 175
		sel_2 210
		sel_589 230
		sel_597 22
		sel_598 169
		sel_599 0
		sel_600 0
	)
)

(instance taxiSign of View
	(properties
		sel_20 {taxiSign}
		sel_1 165
		sel_0 185
		sel_213 6
		sel_303 150
		sel_304 187
		sel_2 284
		sel_4 2
		sel_14 16385
	)
	
	(method (sel_300 param1)
		(switch param1
			(4 (global2 sel_146: sHailTaxi))
			(else 
				(super sel_300: param1 &rest)
			)
		)
	)
)

(instance taxi of Actor
	(properties
		sel_20 {taxi}
		sel_1 375
		sel_0 181
		sel_213 13
		sel_2 852
		sel_3 4
	)
)

(instance man1 of Actor
	(properties
		sel_20 {man1}
		sel_1 117
		sel_0 188
		sel_213 9
		sel_2 212
		sel_14 16384
	)
	
	(method (sel_145)
		(man1 sel_146: sMoveMan1)
	)
)

(instance person2 of Actor
	(properties
		sel_20 {person2}
		sel_1 140
		sel_0 180
		sel_213 9
		sel_2 212
		sel_3 2
		sel_14 16384
	)
	
	(method (sel_145)
		(person2 sel_146: sMovePerson2)
	)
)

(instance person3 of Actor
	(properties
		sel_20 {person3}
		sel_1 -10
		sel_0 183
		sel_213 9
		sel_2 212
		sel_3 3
		sel_14 16384
	)
	
	(method (sel_145)
		(person3 sel_146: sMovePerson3)
	)
)

(instance person4 of Actor
	(properties
		sel_20 {person4}
		sel_1 140
		sel_0 165
		sel_213 9
		sel_2 212
		sel_3 5
		sel_60 11
		sel_14 16400
	)
	
	(method (sel_145)
		(person4 sel_153: 140 165 sel_312: person4Path self)
	)
)

(instance person4Path of Path
	(properties
		sel_20 {person4Path}
	)
	
	(method (sel_64 param1)
		(return [local0 param1])
	)
)

(instance person6 of Actor
	(properties
		sel_20 {person6}
		sel_1 150
		sel_0 167
		sel_213 9
		sel_2 212
		sel_3 7
		sel_60 11
		sel_14 16400
	)
	
	(method (sel_145)
		(person6 sel_153: 150 167 sel_312: person6Path self)
	)
)

(instance person6Path of Path
	(properties
		sel_20 {person6Path}
	)
	
	(method (sel_64 param1)
		(return [local5 param1])
	)
)

(instance person8 of Actor
	(properties
		sel_20 {person8}
		sel_1 -5
		sel_0 189
		sel_213 9
		sel_2 212
		sel_3 11
		sel_14 16384
	)
	
	(method (sel_145)
		(person8 sel_146: sMovePerson8)
	)
)

(instance car of Actor
	(properties
		sel_20 {car}
		sel_1 154
		sel_0 189
		sel_213 13
		sel_2 213
		sel_4 1
		sel_60 14
		sel_14 16400
	)
	
	(method (sel_145)
		(car sel_111:)
	)
)

(instance car2 of Actor
	(properties
		sel_20 {car2}
		sel_1 127
		sel_0 172
		sel_213 13
		sel_2 213
		sel_3 7
		sel_4 3
		sel_14 16384
	)
	
	(method (sel_145)
		(car2
			sel_153: 127 172
			sel_4: (Random 0 4)
			sel_312: car2Path self
		)
	)
)

(instance car2Path of Path
	(properties
		sel_20 {car2Path}
	)
	
	(method (sel_64 param1)
		(return [local10 param1])
	)
)

(instance greyBuilding of Feature
	(properties
		sel_20 {greyBuilding}
		sel_0 100
		sel_213 10
		sel_302 8192
	)
)

(instance nextBuilding of Feature
	(properties
		sel_20 {nextBuilding}
		sel_0 180
		sel_213 7
		sel_302 16384
	)
)

(instance gothicEntrance of Feature
	(properties
		sel_20 {gothicEntrance}
		sel_0 100
		sel_213 5
		sel_302 4096
	)
)

(instance newsBuilding of Feature
	(properties
		sel_20 {newsBuilding}
		sel_0 100
		sel_213 15
		sel_302 2048
	)
)

(instance tree of Feature
	(properties
		sel_20 {tree}
		sel_0 190
		sel_213 19
		sel_302 1024
	)
)

(instance southExitFeature of ExitFeature
	(properties
		sel_20 {southExitFeature}
		sel_6 184
		sel_7 195
		sel_8 189
		sel_9 289
		sel_33 11
		sel_583 3
		sel_213 18
	)
)

(instance noise of Sound
	(properties
		sel_20 {noise}
		sel_99 1
	)
)
