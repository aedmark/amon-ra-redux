;;; Sierra Script 1.0 - (do not remove this comment)
(script# 0)
(include sci.sh)
(use LBIconItem)
(use LBRoom)
(use ego)
(use Print)
(use Messager)
(use RTRandCycle)
(use PseudoMouse)
(use IconI)
(use Osc)
(use PolyPath)
(use Polygon)
(use StopWalk)
(use Timer)
(use Grooper)
(use SysWindow)
(use Sound)
(use Game)
(use InvI)
(use Obj)

(public
	LB2 0
	proc0_1 1
	proc0_2 2
	proc0_3 3
	proc0_4 4
	proc0_5 5
	proc0_6 6
	proc0_7 7
	proc0_8 8
	lb2Win 9
	proc0_10 10
	proc0_11 11
	proc0_12 12
	proc0_13 13
	proc0_14 14
	proc0_15 15
	proc0_16 16
	proc0_17 17
)

(local
	gEgo
	gGame
	global2
	global3 =  6
	global4
	gSel_561
	gRegions
	gTimers
	gSounds
	gInv
	gSel_563
	gSel_40
	gGSel_40
	gTheGSel_40
	global14
	global15
	global16
	global17 =  7
	gGSel_188
	gSel_582
	gWalkCursor =  999
	global21 =  997
	gSel_30 =  1
	global23 =  4
	global24
	gSel_201
	global26 =  1
	global27
	gLocales
	global29
	global30 =  10
	gSel_413
	gSel_562
	gSFeatures
	global34
	global35
	global36 =  -1
	global37
	gLb2Win
	global39
	global40
	global41
	global42
	global43
	global44
	global45
	global46
	global47
	global48
	global49
	global50
	global51
	global52
	global53
	global54
	global55
	global56
	global57
	global58
	global59
	global60
	global61
	global62
	gGameControls
	gLb2FtrInit
	gLb2DoVerbCode
	gLb2ApproachCode
	global67 =  1
	global68
	gIconBar
	gSel_1
	gSel_0
	gLb2KDH
	gLb2MDH
	gLb2DH
	global75
	global76
	gPseudoMouse
	gTheDoits
	gSel_188 =  60
	gUser
	global81
	global82
	global83
	gEventHandlerSel_109
	gSel_30_2
	global86
	global87
	gSel_45
	gNarrator
	global90
	gLb2Messager
	global92
	gLb2WH
	global94 =  2
	gListSel_109
	global96
	global97
	global98
	global99
	gStopGroop
	global101 =  1234
	gSel_608
	gGameMusic2
	global104
	global105
	global106
	global107 =  100
	gGUserSel_237
	gGUserSel_347
	global110
	global111
	global112
	global113
	global114
	global115
	global116
	global117
	global118
	global119
	global120
	gGIconBarSel_207
	global122
	global123
	global124
	global125
	global126
	global127
	global128
	global129
	gLb2Exits
	global131 =  1
	global132 =  1
	global133 =  1
	global134 =  1
	global135 =  1
	global136
	global137
	global138
	global139
	global140
	global141
	global142
	global143
	global144
	global145
	global146
	global147
	global148
	global149
	global150 =  4
	global151
	global152
	global153
	global154
	global155
	global156
	global157
	global158
	global159
	global160
	global161
	global162
	global163
	global164
	global165
	global166
	global167
	gSel_212
	global169
	global170
	global171
	global172
	global173
	global174
	global175
	global176
	gSel_212_2
	global178
	global179
	global180
	global181
	global182
	global183
	global184
	global185
	global186
	global187
	global188
	global189
	global190
	global191
	global192
	global193
	global194
	global195
	global196
	global197
	global198
	global199
	global200
	global201
	global202
	global203
	global204
	global205
	global206
	global207
	global208
	global209
	global210
	global211
	global212
	global213
	global214
	global215
	global216
	global217
	global218
	global219
	global220
	global221
	global222
	global223
	global224
	global225
	global226
	global227
	global228
	global229
	global230
	global231
	global232
	global233
	global234
	global235
	global236
	global237
	global238
	global239
	global240
	global241
	global242
	global243
	global244
	global245
	global246
	global247
	global248
	global249
	global250
	global251
	global252
	global253
	global254
	global255
	global256
	global257
	global258
	global259
	global260
	global261
	global262
	global263
	global264
	global265
	global266
	global267
	global268
	global269
	global270
	global271
	global272
	global273
	global274
	global275
	global276
	global277
	global278
	global279
	global280
	global281
	global282
	global283
	global284
	global285
	global286
	global287
	global288
	global289
	global290
	global291
	global292
	global293
	global294
	global295
	global296
	global297
	global298
	global299
	global300
	global301
	global302
	global303
	global304
	global305
	global306
	global307
	global308
	global309
	global310
	global311
	global312
	global313
	global314
	global315
	global316
	global317
	global318
	global319
	global320
	global321
	global322
	global323
	global324
	global325
	global326
	global327
	global328
	global329
	global330
	global331
	global332
	global333
	global334
	global335
	global336
	global337
	global338
	global339
	global340
	global341
	global342
	global343
	global344
	global345
	global346
	global347
	global348
	global349
	global350
	global351
	global352
	global353
	global354
	global355
	global356
	global357
	global358
	global359
	global360
	global361
	global362
	global363
	global364
	global365
	global366
	global367
	global368
	global369
	global370
	global371
	global372
	global373
	global374
	global375
	global376
	global377
	global378
	global379
	global380
	global381
	global382
	global383
	global384
	global385
	global386
	global387
	global388
	global389
	global390
	global391
	global392
	global393
	global394
	global395
	global396
	global397
	global398
	global399
)
(procedure (proc0_1 param1 param2)
	(return (if (& (param1 sel_337: 1) param2) (return 1) else 0))
)

(procedure (proc0_2 param1)
	(return
		(&
			[global186 (/ param1 16)]
			(>> $8000 (mod param1 16))
		)
	)
)

(procedure (proc0_3 param1 &tmp temp0)
	(= temp0 (proc0_2 param1))
	(= [global186 (/ param1 16)]
		(|
			[global186 (/ param1 16)]
			(>> $8000 (mod param1 16))
		)
	)
	(return temp0)
)

(procedure (proc0_4 param1 &tmp temp0)
	(= temp0 (proc0_2 param1))
	(= [global186 (/ param1 16)]
		(&
			[global186 (/ param1 16)]
			(~ (>> $8000 (mod param1 16)))
		)
	)
	(return temp0)
)

(procedure (proc0_5 param1 param2 param3 param4 &tmp temp0 temp1 temp2 temp3)
	(= temp3 0)
	(if (IsObject param2)
		(= temp1 (param2 sel_1?))
		(= temp2 (param2 sel_0?))
		(if (== argc 3) (= temp3 param3))
	else
		(= temp1 param2)
		(= temp2 param3)
		(if (== argc 4) (= temp3 param4))
	)
	(= temp0
		(GetAngle (param1 sel_1?) (param1 sel_0?) temp1 temp2)
	)
	(param1
		sel_253: temp0 (if (IsObject temp3) temp3 else 0)
	)
)

(procedure (proc0_6 param1 param2)
	(cond 
		((proc999_5 param2 4 3 38) (gLb2Messager sel_295: 0 param2 0 0 0 0))
		((proc999_5 param2 6 1 8) (gLb2Messager sel_295: 0 param2 0 (Random 1 2) 0 0))
		((== param2 2) (gLb2Messager sel_295: 0 param2 0 (Random 1 4) 0 0))
		(else (gLb2Messager sel_295: 0 47 0 0 0 0))
	)
)

(procedure (proc0_7 &tmp temp0)
	(gUser sel_237: gGUserSel_237 sel_347: gGUserSel_347)
	(= temp0 0)
	(while (< temp0 8)
		(if (& global116 (>> $8000 temp0))
			(gIconBar sel_233: temp0)
		)
		(++ temp0)
	)
)

(procedure (proc0_8 param1)
	(if param1
		(gIconBar
			sel_81: icon0
			sel_129: (icon10 sel_110: sel_117:)
		)
		(if (== (gIconBar sel_207?) icon0)
			(gIconBar sel_207: icon10 sel_228: 0)
			(gGame sel_197: (icon10 sel_33?))
		)
	else
		(gIconBar
			sel_81: icon10
			sel_129: (icon0 sel_110: sel_117:)
		)
		(if (== (gIconBar sel_207?) icon10)
			(gIconBar sel_207: icon0 sel_228: icon0)
			(gGame sel_197: (icon0 sel_33?))
		)
	)
)

(procedure (proc0_10 param1 param2)
	(= param1 (& param1 $00ff))
	(return
		(if (and (> argc 1) param2)
			(== (- param1 1) (& global124 (- param1 1)))
		else
			(& global124 param1)
		)
	)
)

(procedure (proc0_11 param1 param2 param3 param4 param5)
	(switch (gGame sel_84?)
		(49 param1)
		(34 param2)
		(33 param3)
		(39 param4)
		(else  param5)
	)
)

(procedure (proc0_12)
	(proc0_11 1026 1040 1051 1050 995)
)

(procedure (proc0_13)
	(proc0_3 7)
	(proc0_3 8)
	(proc0_3 9)
	(proc0_3 24)
	(proc0_3 26)
	(proc0_3 27)
	(proc0_3 28)
	(proc0_3 29)
	(proc0_3 34)
	(proc0_3 43)
	((ScriptID 21 0) sel_57: 791)
	((ScriptID 21 0) sel_57: 263)
	((ScriptID 21 0) sel_57: 264)
	((ScriptID 21 0) sel_57: 265)
	((ScriptID 21 0) sel_57: 266)
	((ScriptID 21 0) sel_57: 267)
	((ScriptID 21 0) sel_57: 268)
	((ScriptID 21 0) sel_57: 269)
	((ScriptID 21 0) sel_57: 270)
	((ScriptID 21 0) sel_57: 271)
	((ScriptID 21 0) sel_57: 272)
	((ScriptID 21 1) sel_57: 518)
	((ScriptID 21 0) sel_57: 520)
	(ego sel_584: 1)
	(ego sel_350: -1 22)
	(ego sel_350: -1 6)
)

(procedure (proc0_14)
	(proc0_13)
	(proc0_3 1)
	(proc0_3 25)
	(proc0_3 23)
	((ScriptID 21 0) sel_57: 797)
	(ego sel_350: -1 28)
	(ego sel_350: -1 21)
)

(procedure (proc0_15)
	(proc0_14)
	(= global129 13)
	(proc0_3 2)
	(proc0_3 3)
	(proc0_3 4)
	(proc0_3 22)
	(proc0_3 31)
	(proc0_3 33)
	(proc0_3 35)
	(proc0_3 36)
	(proc0_3 37)
	(proc0_3 40)
	(proc0_3 42)
	(proc0_3 49)
	((ScriptID 21 0) sel_57: 790)
	((ScriptID 21 0) sel_57: 789)
	((ScriptID 21 0) sel_57: 787)
	((ScriptID 21 0) sel_57: 783)
	((ScriptID 21 0) sel_57: 788)
	((ScriptID 21 0) sel_57: 798)
	((ScriptID 21 0) sel_57: 802)
	((ScriptID 21 0) sel_57: 779)
	((ScriptID 21 0) sel_57: 777)
	((ScriptID 21 0) sel_57: 776)
	((ScriptID 21 0) sel_57: 778)
	((ScriptID 21 0) sel_57: 1025)
	((ScriptID 21 0) sel_57: 1030)
	(ego sel_350: -1 20 18 14 19 29 33 10 8 7 9 11)
)

(procedure (proc0_16 &tmp temp0)
	(proc0_15)
	(proc0_3 72)
	(proc0_3 5)
	(proc0_3 6)
	(proc0_3 62)
	((ScriptID 21 0) sel_57: 794)
	((ScriptID 21 0) sel_57: 785)
	((ScriptID 21 0) sel_57: 786)
	((ScriptID 21 0) sel_57: 799)
	((ScriptID 21 0) sel_57: 796)
	((ScriptID 21 0) sel_57: 795)
	((ScriptID 21 0) sel_57: 781)
	((ScriptID 21 0) sel_57: 800)
	((ScriptID 21 0) sel_57: 782)
	((ScriptID 21 0) sel_57: 780)
	(ego sel_351: 6 0 1 3 4 5 8 9 18 23 32)
	((ScriptID 21 1) sel_57: 775)
	((ScriptID 21 1) sel_57: 769)
	((ScriptID 21 1) sel_57: 770)
	((ScriptID 21 1) sel_57: 772)
	((ScriptID 21 1) sel_57: 773)
	((ScriptID 21 1) sel_57: 774)
	((ScriptID 21 1) sel_57: 777)
	((ScriptID 21 1) sel_57: 778)
	((ScriptID 21 1) sel_57: 787)
	((ScriptID 21 1) sel_57: 792)
	((ScriptID 21 1) sel_57: 801)
	(= temp0 1)
	(while (< temp0 27)
		((ScriptID 21 0) sel_57: (+ temp0 1088))
		(++ temp0)
	)
	(ego sel_350: -1 25 16 17 30 27 26 12 31 13)
)

(procedure (proc0_17)
	(proc0_16)
	(proc0_3 10)
	((ScriptID 21 0) sel_57: 784)
	((ScriptID 21 0) sel_57: 803)
	(ego sel_350: -1 34 15)
)

(instance gameMusic1 of Sound
	(properties
		sel_20 {gameMusic1}
	)
)

(instance gameMusic2 of Sound
	(properties
		sel_20 {gameMusic2}
	)
)

(class WrapMusic of List
	(properties
		sel_20 {WrapMusic}
		sel_24 0
		sel_86 0
		sel_608 0
		sel_609 0
		sel_610 0
		sel_94 127
		sel_611 0
	)
	
	(method (sel_110 theSel_610)
		(Sounds sel_119: 174)
		(if (not sel_608) (= sel_608 gSel_608))
		(= sel_610 theSel_610)
		(= sel_609 0)
		(self sel_118: &rest sel_145:)
	)
	
	(method (sel_111 param1)
		(sel_608 sel_42: 0)
		(if (and argc param1)
			(super sel_111:)
		else
			(self sel_125:)
		)
	)
	
	(method (sel_145 &tmp temp0 temp1 temp2)
		(cond 
			((proc999_5 (sel_608 sel_165?) -1 0)
				(= temp0 1)
				(cond 
					(
					(and (== sel_610 -1) (== sel_609 (- sel_86 1))) (= temp0 -1))
					((== sel_609 sel_86)
						(switch sel_610
							(1 (= sel_609 0))
							(else 
								(self sel_125: sel_111:)
								(return)
							)
						)
					)
				)
				(if (> (= temp1 (self sel_64: sel_609)) 1000)
					(= temp1 (- temp1 1000))
					(= temp2 1)
				else
					(= temp2 0)
				)
				(sel_608
					sel_40: temp1
					sel_155: temp0
					sel_99: (if temp2 5 else 1)
					sel_39: sel_94 self
				)
				(++ sel_609)
			)
			(sel_611 (sel_608 sel_168:))
			(else (= sel_94 (sel_608 sel_94?)))
		)
	)
	
	(method (sel_168 param1)
		(if (IsObject sel_608)
			(if (and argc (not param1))
				(= sel_611 0)
				(sel_608 sel_168: 0 sel_170: sel_94 5 5 0)
			else
				(= sel_611 1)
				(sel_608 sel_170: 0 5 5 0)
			)
		)
	)
)

(class Actions of Code
	(properties
		sel_20 {Actions}
	)
	
	(method (sel_300)
		(return 0)
	)
)

(instance stopGroop of Grooper
	(properties
		sel_20 {stopGroop}
	)
)

(instance walkCursor of Cursor
	(properties
		sel_20 {walkCursor}
	)
)

(instance lookCursor of Cursor
	(properties
		sel_20 {lookCursor}
		sel_2 1
	)
)

(instance doCursor of Cursor
	(properties
		sel_20 {doCursor}
		sel_2 2
	)
)

(instance talkCursor of Cursor
	(properties
		sel_20 {talkCursor}
		sel_2 3
	)
)

(instance askCursor of Cursor
	(properties
		sel_20 {askCursor}
		sel_2 4
	)
)

(instance exitCursor of Cursor
	(properties
		sel_20 {exitCursor}
		sel_2 6
	)
)

(instance lb2KDH of EventHandler
	(properties
		sel_20 {lb2KDH}
	)
)

(instance lb2MDH of EventHandler
	(properties
		sel_20 {lb2MDH}
	)
)

(instance lb2DH of EventHandler
	(properties
		sel_20 {lb2DH}
	)
)

(instance lb2WH of EventHandler
	(properties
		sel_20 {lb2WH}
	)
)

(instance lb2Exits of EventHandler
	(properties
		sel_20 {lb2Exits}
	)
)

(class LB2 of Game
	(properties
		sel_20 {LB2}
		sel_142 0
		sel_83 1
		sel_84 0
		sel_85 0
		sel_396 3
		sel_397 0
		sel_398 0
	)
	
	(method (sel_110 &tmp temp0 [temp1 5] [temp6 16])
		(StrSplit @temp1 @temp6 0)
		Print
		StopWalk
		Polygon
		PolyPath
		Timer
		LBRoom
		ego
		IconBar
		Inv
		LBIconItem
		(ScriptID 982)
		Narrator
		Osc
		(super sel_110:)
		(= global27 {x.yyy.zzz})
		(= global112 {991-999-9999})
		(= global113 {9999-999999})
		(= global114 {992-999-9999})
		((ScriptID 14 0) sel_110:)
		(DisposeScript 14)
		((ScriptID 15 0) sel_110:)
		(= gWalkCursor walkCursor)
		(= gLb2DoVerbCode lb2DoVerbCode)
		(= gLb2FtrInit lb2FtrInit)
		(= gLb2ApproachCode lb2ApproachCode)
		(= gStopGroop stopGroop)
		(= gLb2Messager lb2Messager)
		((= gLb2KDH lb2KDH) sel_118:)
		((= gLb2MDH lb2MDH) sel_118:)
		((= gLb2DH lb2DH) sel_118:)
		((= gLb2WH lb2WH) sel_118:)
		((= gLb2Exits lb2Exits) sel_118:)
		((= gListSel_109 (List sel_109:))
			sel_20: {altPolys}
			sel_118:
		)
		(gLb2MDH sel_129: lb2Exits)
		(gLb2KDH sel_129: lb2Exits)
		(= gPseudoMouse PseudoMouse)
		(WrapMusic sel_118:)
		((= gSel_608 gameMusic1)
			sel_166: self
			sel_99: 1
			sel_110:
		)
		((= gGameMusic2 gameMusic2)
			sel_166: self
			sel_99: 1
			sel_110:
		)
		((= gIconBar IconBar)
			sel_118: icon0 icon1 icon2 icon3 icon4 icon6 icon7 icon8 icon9
			sel_119: 110
			sel_119: 211 global157
			sel_119: 212 gSel_212_2
			sel_207: icon0
			sel_226: icon6
			sel_227: icon9
			sel_228: icon0
			sel_233: 5
			sel_233:
			sel_29: 3072
		)
		(if (GameIsRestarting)
			(MemorySegment 1 @global107)
		else
			(= global107 28)
		)
		(if (FileIO fiEXISTS {10.scr})
			(= global110 1)
		else
			(= global110 0)
		)
		(gIconBar sel_177:)
		(= gEgo ego)
		(gUser sel_341: gEgo sel_237: 0 sel_347: 0)
		(self sel_399: global107)
	)
	
	(method (sel_57 &tmp theSel_397 theSel_398)
		(if
			(and
				(gLb2Exits sel_86?)
				(== (gIconBar sel_207?) (gIconBar sel_228?))
			)
			(gLb2Exits sel_119: 57)
		)
		(if sel_397
			(= theSel_397 sel_397)
			(= theSel_398 sel_398)
			(= sel_397 (= sel_398 0))
			(proc999_7 theSel_397 theSel_398)
		)
		(super sel_57:)
	)
	
	(method (sel_62 &tmp temp0)
		(= gLb2Win lb2Win)
		(= gWalkCursor walkCursor)
		(if
		(and (proc999_5 gSel_40 330 335) (== global123 2))
			(Palette palSET_INTENSITY 0 255 60)
		else
			(Palette palSET_INTENSITY 0 255 100)
		)
		(super sel_62: &rest)
	)
	
	(method (sel_399 param1)
		(gGame sel_197: global21)
		(gPseudoMouse sel_167:)
		(if (and (== global123 5) (not (proc0_2 123)))
			(if (not (gEgo sel_238: 10))
				(gEgo sel_350: 10)
			)
			(if (not (gEgo sel_238: 14))
				(gEgo sel_350: 14)
			)
			(if (not (gEgo sel_238: 16))
				(gEgo sel_350: 16)
			)
			(if (== global150 0)
				(= global150 4)
			)
			(proc0_3 123)
		)
		(if gSel_201 (gSel_201 sel_111:))
		(if
			(and
				(IsObject gEventHandlerSel_109)
				(gEventHandlerSel_109 sel_24?)
			)
			(gEventHandlerSel_109 sel_119: 111 1)
		)
		(if (gLb2Exits sel_86?) (gLb2Exits sel_119: 111))
		(gNarrator
			sel_1: -1
			sel_0: -1
			sel_291: 1
			sel_537: 0
			sel_538: 1
			sel_203: 0
			sel_540: 0
			sel_20: {Narrator}
		)
		(gIconBar sel_233:)
		(super sel_399: param1)
	)
	
	(method (sel_400 param1 &tmp temp0 temp1 [temp2 2])
		((ScriptID 11) sel_57: param1)
		(= temp1 0)
		(while (< temp1 (gTimers sel_86?))
			(gTimers sel_81: (= temp0 (gTimers sel_64: 0)))
			(gTimers sel_118: temp0)
			(++ temp1)
		)
		(= temp1 0)
		(while (< temp1 (WrapMusic sel_86?))
			(WrapMusic sel_81: (= temp0 (WrapMusic sel_64: 0)))
			(WrapMusic sel_118: temp0)
			(++ temp1)
		)
		(if
			(and
				(!= (- (MemoryInfo 1) 2) (MemoryInfo 0))
				(Print
					sel_198: 1 0 0 1 0 0 10
					sel_205: 0 1 0 1 1 0 12 10
					sel_205: 1 1 0 2 1 70 12 10
					sel_110:
				)
			)
			(SetDebug)
		)
		(if
			(and
				(proc999_5
					param1
					335
					340
					350
					355
					360
					370
					400
					420
					500
					510
					520
					525
					530
					540
					550
					560
					565
					430
					435
					440
					448
					450
					454
					455
					456
					460
					480
					490
					521
					600
					610
					620
					630
					640
					650
					666
					660
					700
					710
					715
					720
					730
					740
				)
				(!= global123 5)
			)
			(ScriptID 90)
		)
		(if
			(and
				(proc999_5 param1 335 340 350 355 360 370 400)
				(== global123 2)
			)
			(ScriptID 93)
		)
		(if (proc999_5 param1 280 210 260 300) (ScriptID 91))
		(if
			(and
				(== global123 5)
				(proc999_5
					param1
					420
					430
					435
					440
					448
					450
					454
					460
					480
					490
					660
				)
			)
			(ScriptID 94)
		)
		(if
			(proc999_5
				param1
				100
				105
				110
				120
				140
				150
				155
				160
				180
				190
				220
			)
			(ScriptID 92)
		)
		(if (and global110 (not (proc999_5 param1 100)))
			((ScriptID 10 0) sel_110:)
		)
		(gIconBar sel_177:)
		(super sel_400: param1)
		(if
			(and
				(gEgo sel_245?)
				(not (gEgo sel_59?))
				((gEgo sel_245?) sel_114: StopWalk)
			)
			(gEgo sel_155: stopGroop)
		)
		(if (== (gIconBar sel_207?) (gIconBar sel_64: 5))
			(gIconBar sel_207: (gIconBar sel_64: 0))
		)
	)
	
	(method (sel_101)
		(global2 sel_28: 6 sel_417: 780)
		(gSel_561 sel_119: 102)
		(Animate (gSel_561 sel_24?) 0)
		(MemorySegment 0 @global107 2)
		(super sel_101:)
	)
	
	(method (sel_76 &tmp theGLb2Win theGWalkCursor temp2 eventHandlerSel_109)
		(= eventHandlerSel_109 (EventHandler sel_109:))
		(= temp2 0)
		(while (< temp2 (gSel_563 sel_86?))
			(eventHandlerSel_109 sel_118: (gSel_563 sel_64: temp2))
			(++ temp2)
		)
		(DrawPic 780 dpOPEN_CENTEREDGE)
		(gSel_561 sel_119: 102)
		(Animate 0)
		(= theGWalkCursor gWalkCursor)
		(= gWalkCursor 999)
		(= theGLb2Win gLb2Win)
		(= gLb2Win SysWindow)
		(super sel_76: &rest)
		(DrawPic (global2 sel_408?) dpOPEN_NO_TRANSITION)
		(gSel_561 sel_119: 216)
		(= temp2 0)
		(while (< temp2 (eventHandlerSel_109 sel_86?))
			(gSel_563 sel_118: (eventHandlerSel_109 sel_64: temp2))
			(++ temp2)
		)
		(eventHandlerSel_109 sel_125: sel_111:)
		(gSel_563 sel_57:)
		(Animate (gSel_561 sel_24?) 0)
		(= gLb2Win theGLb2Win)
		(= gWalkCursor theGWalkCursor)
		(if
		(== (= temp2 ((gIconBar sel_207?) sel_33?)) 999)
			(gGame sel_197: global21)
		else
			(gGame sel_197: temp2)
		)
	)
	
	(method (sel_75 &tmp theGLb2Win theGWalkCursor temp2)
		(= theGWalkCursor gWalkCursor)
		(= gWalkCursor 999)
		(= theGLb2Win gLb2Win)
		(= gLb2Win SysWindow)
		(super sel_75: &rest)
		(= gLb2Win theGLb2Win)
		(= gWalkCursor theGWalkCursor)
		(if
		(== (= temp2 ((gIconBar sel_207?) sel_33?)) 999)
			(gGame sel_197: global21)
		else
			(gGame sel_197: temp2)
		)
	)
	
	(method (sel_133 param1)
		(if (param1 sel_73?) (return 1))
		(return
			(switch (param1 sel_31?)
				(4
					(switch (param1 sel_37?)
						(9
							(if
							(not (& ((gIconBar sel_64: 6) sel_14?) $0004))
								(if gEventHandlerSel_109 (return gEventHandlerSel_109))
								(gEgo sel_586:)
								(param1 sel_73: 1)
							)
						)
						(3840
							(if
							(not (& ((gIconBar sel_64: 6) sel_14?) $0004))
								(if gEventHandlerSel_109 (return gEventHandlerSel_109))
								(gEgo sel_586:)
								(param1 sel_73: 1)
							)
						)
						(17
							(gGame sel_100:)
							(param1 sel_73: 1)
						)
						(3
							(if
							(not (& ((gIconBar sel_64: 7) sel_14?) $0004))
								(gGame sel_612:)
							)
						)
						(15360
							(cond 
								((gGame sel_404:) (gGame sel_404: 0))
								((> global106 1) (gGame sel_404: 15))
								(else (gGame sel_404: 1))
							)
							(param1 sel_73: 1)
						)
						(16128
							(if
							(not (& ((gIconBar sel_64: 7) sel_14?) $0004))
								(if gEventHandlerSel_109 (return gEventHandlerSel_109))
								(gGame sel_75:)
								(param1 sel_73: 1)
							)
						)
						(16640
							(if
							(not (& ((gIconBar sel_64: 7) sel_14?) $0004))
								(if gEventHandlerSel_109 (return gEventHandlerSel_109))
								(gGame sel_76:)
								(param1 sel_73: 1)
							)
						)
						(43
							(if (gUser sel_343?)
								(= global3 (proc999_3 0 (-- global3)))
								(gEgo sel_352: global3)
							)
						)
						(45
							(if (gUser sel_343?)
								(++ global3)
								(gEgo sel_352: global3)
							)
						)
						(61
							(if (gUser sel_343?) (gEgo sel_352: 6))
						)
					)
				)
			)
		)
	)
	
	(method (sel_197 theGSel_582_2 param2 param3 param4 &tmp theGSel_582)
		(= theGSel_582 gSel_582)
		(if argc
			(if (IsObject theGSel_582_2)
				((= gSel_582 theGSel_582_2) sel_110:)
			else
				(SetCursor (= gSel_582 theGSel_582_2) 0 0)
			)
		)
		(if (and (> argc 1) (not param2)) (SetCursor 996 0 0))
		(if (> argc 2)
			(if (< param3 0) (= param3 0))
			(if (< param4 0) (= param4 0))
			(SetCursor param3 param4)
		)
		(return theGSel_582)
	)
	
	(method (sel_402)
	)
	
	(method (sel_100)
		(if
			(Print
				sel_198: 12 0 0 1 0 0 0
				sel_206: 992 0 0 0 15
				sel_205: 1 12 0 8 1 140 67 0
				sel_205: 0 12 0 9 1 140 87 0
				sel_204: 1
				sel_110:
			)
			(super sel_100: 1)
		)
	)
	
	(method (sel_71)
		(if gSel_201 (gSel_201 sel_111:))
		(if (gUser sel_347:)
			(gLb2Messager sel_295: 0 ((gUser sel_346?) sel_37?))
		)
	)
	
	(method (sel_587)
		(if (not gGIconBarSel_207)
			(= gGIconBarSel_207 (gIconBar sel_207?))
		)
		(= gGUserSel_237 (gUser sel_237:))
		(= gGUserSel_347 (gUser sel_347:))
		(gUser sel_237: 0 sel_347: 0)
		(gEgo sel_312: 0)
		(= global116 0)
		(gIconBar sel_119: 96 checkIcon)
		(gIconBar sel_207: (gIconBar sel_64: 7))
		(gIconBar sel_233: 0 1 2 3 4 5 6)
		(if (not (HaveMouse))
			(gGame sel_197: 996)
		else
			(gGame sel_197: global21)
		)
	)
	
	(method (sel_588 param1)
		(gUser sel_237: 1 sel_347: 1)
		(gIconBar sel_177: 0 1 2 3 4 5 6)
		(gIconBar sel_177: 7)
		(if (and argc param1) (proc0_7))
		(if (not (gIconBar sel_225?)) (gIconBar sel_233: 5))
		(if
			(and
				gGIconBarSel_207
				(or
					(!= gGIconBarSel_207 icon10)
					(== (gIconBar sel_64: 0) icon10)
				)
			)
			(gIconBar sel_207: gGIconBarSel_207)
			(gGame sel_197: (gGIconBarSel_207 sel_33?))
			(if
				(and
					(== (gIconBar sel_207?) (gIconBar sel_64: 5))
					(not (gIconBar sel_225?))
				)
				(gIconBar sel_231:)
			)
		)
		(= gGIconBarSel_207 0)
		(gGame sel_197: ((gIconBar sel_207?) sel_33?) 1)
	)
	
	(method (sel_87 param1 param2)
		(if (and (> argc 1) (proc0_3 param2)) (= param1 0))
		(if param1 (gGame sel_388: param1))
	)
	
	(method (sel_612 &tmp temp0)
		((ScriptID 24 0) sel_110: sel_216: sel_111:)
	)
	
	(method (sel_613)
		(if
			(proc999_5
				gSel_40
				435
				454
				455
				520
				521
				525
				550
				560
				565
				620
				650
			)
			(gLb2Messager sel_295: 11 0 0 0 0 0)
		else
			((ScriptID 13 0) sel_57:)
		)
	)
)

(instance icon0 of IconI
	(properties
		sel_20 {icon0}
		sel_2 990
		sel_3 0
		sel_4 0
		sel_31 20480
		sel_37 3
		sel_14 65
		sel_208 990
		sel_209 9
		sel_213 1
		sel_215 12
	)
	
	(method (sel_110)
		(= sel_33 walkCursor)
		(super sel_110:)
	)
	
	(method (sel_178 &tmp temp0)
		(return
			(if (super sel_178: &rest)
				(gIconBar sel_102:)
				(return 1)
			else
				(return 0)
			)
		)
	)
)

(instance icon1 of IconI
	(properties
		sel_20 {icon1}
		sel_2 990
		sel_3 1
		sel_4 0
		sel_37 1
		sel_14 65
		sel_208 990
		sel_209 9
		sel_213 2
		sel_215 12
	)
	
	(method (sel_110)
		(= sel_33 lookCursor)
		(super sel_110:)
	)
)

(instance icon2 of IconI
	(properties
		sel_20 {icon2}
		sel_2 990
		sel_3 2
		sel_4 0
		sel_37 4
		sel_14 65
		sel_208 990
		sel_209 9
		sel_213 3
		sel_215 12
	)
	
	(method (sel_110)
		(= sel_33 doCursor)
		(super sel_110:)
	)
)

(instance icon3 of IconI
	(properties
		sel_20 {icon3}
		sel_2 990
		sel_3 3
		sel_4 0
		sel_37 2
		sel_14 65
		sel_208 990
		sel_209 9
		sel_213 4
		sel_215 12
	)
	
	(method (sel_110)
		(= sel_33 talkCursor)
		(super sel_110:)
	)
)

(instance icon4 of IconI
	(properties
		sel_20 {icon4}
		sel_2 990
		sel_3 4
		sel_4 0
		sel_37 6
		sel_14 65
		sel_208 990
		sel_209 9
		sel_213 5
		sel_215 12
	)
	
	(method (sel_110)
		(= sel_33 askCursor)
		(super sel_110:)
	)
)

(instance icon6 of IconI
	(properties
		sel_20 {icon6}
		sel_2 990
		sel_3 5
		sel_4 0
		sel_33 999
		sel_37 0
		sel_14 65
		sel_208 990
		sel_209 9
		sel_210 1
		sel_213 9
		sel_215 12
	)
	
	(method (sel_178 param1 &tmp eventSel_109 temp1 gIconBarSel_225 temp3 temp4)
		(return
			(cond 
				((& sel_14 $0004) 0)
				((and argc param1 (& sel_14 $0001))
					(if (= gIconBarSel_225 (gIconBar sel_225?))
						(= temp3
							(+
								(/
									(-
										(- sel_9 sel_7)
										(CelWide
											(gIconBarSel_225 sel_2?)
											(+ (gIconBarSel_225 sel_3?) 1)
											(gIconBarSel_225 sel_4?)
										)
									)
									2
								)
								sel_7
							)
						)
						(= temp4
							(+
								(gIconBar sel_0?)
								(/
									(-
										(- sel_8 sel_6)
										(CelHigh
											(gIconBarSel_225 sel_2?)
											(+ (gIconBarSel_225 sel_3?) 1)
											(gIconBarSel_225 sel_4?)
										)
									)
									2
								)
								sel_6
							)
						)
					)
					(DrawCel sel_2 sel_3 (= temp1 1) sel_7 sel_6 -1)
					(if (= gIconBarSel_225 (gIconBar sel_225?))
						(DrawCel
							(gIconBarSel_225 sel_2?)
							(+ 1 (gIconBarSel_225 sel_3?))
							(gIconBarSel_225 sel_4?)
							temp3
							temp4
							-1
						)
					)
					(Graph grUPDATE_BOX sel_6 sel_7 sel_8 sel_9 1)
					(while
					(!= ((= eventSel_109 (Event sel_109:)) sel_31?) 2)
						(eventSel_109 sel_148:)
						(cond 
							((self sel_218: eventSel_109)
								(if (not temp1)
									(DrawCel sel_2 sel_3 (= temp1 1) sel_7 sel_6 -1)
									(if (= gIconBarSel_225 (gIconBar sel_225?))
										(DrawCel
											(gIconBarSel_225 sel_2?)
											(+ 1 (gIconBarSel_225 sel_3?))
											(gIconBarSel_225 sel_4?)
											temp3
											temp4
											-1
										)
									)
									(Graph grUPDATE_BOX sel_6 sel_7 sel_8 sel_9 1)
								)
							)
							(temp1
								(DrawCel sel_2 sel_3 (= temp1 0) sel_7 sel_6 -1)
								(if (= gIconBarSel_225 (gIconBar sel_225?))
									(DrawCel
										(gIconBarSel_225 sel_2?)
										(+ 1 (gIconBarSel_225 sel_3?))
										(gIconBarSel_225 sel_4?)
										temp3
										temp4
										-1
									)
								)
								(Graph grUPDATE_BOX sel_6 sel_7 sel_8 sel_9 1)
							)
						)
						(eventSel_109 sel_111:)
					)
					(eventSel_109 sel_111:)
					(if (== temp1 1)
						(DrawCel sel_2 sel_3 0 sel_7 sel_6 -1)
						(if (= gIconBarSel_225 (gIconBar sel_225?))
							(DrawCel
								(gIconBarSel_225 sel_2?)
								(+ 1 (gIconBarSel_225 sel_3?))
								(gIconBarSel_225 sel_4?)
								temp3
								temp4
								-1
							)
						)
						(Graph grUPDATE_BOX sel_6 sel_7 sel_8 sel_9 1)
					)
					temp1
				)
				(else 1)
			)
		)
	)
)

(instance icon7 of IconI
	(properties
		sel_20 {icon7}
		sel_2 990
		sel_3 6
		sel_4 0
		sel_33 999
		sel_31 0
		sel_37 0
		sel_14 67
		sel_208 990
		sel_209 9
		sel_213 6
		sel_215 12
	)
	
	(method (sel_216)
		(= sel_3 (if (gEgo sel_584?) 11 else 6))
		(super sel_216: &rest)
	)
	
	(method (sel_178)
		(return
			(if (super sel_178: &rest)
				(gIconBar sel_102:)
				(gEgo sel_586:)
				(return 1)
			else
				(return 0)
			)
		)
	)
)

(instance icon8 of IconI
	(properties
		sel_20 {icon8}
		sel_2 990
		sel_3 7
		sel_4 0
		sel_33 999
		sel_37 7
		sel_14 67
		sel_208 990
		sel_209 9
		sel_213 7
		sel_215 12
	)
	
	(method (sel_178)
		(return
			(if (super sel_178: &rest)
				(gIconBar sel_102:)
				(gGame sel_612:)
				(return 1)
			else
				(return 0)
			)
		)
	)
)

(instance icon9 of IconI
	(properties
		sel_20 {icon9}
		sel_2 990
		sel_3 8
		sel_4 0
		sel_33 9
		sel_31 8192
		sel_37 12
		sel_14 3
		sel_208 990
		sel_209 9
		sel_213 8
		sel_215 12
	)
)

(instance icon10 of IconI
	(properties
		sel_20 {icon10}
		sel_2 990
		sel_3 10
		sel_4 0
		sel_37 13
		sel_14 65
		sel_208 990
		sel_209 9
		sel_213 10
		sel_215 12
	)
	
	(method (sel_110)
		(= sel_33 exitCursor)
		(super sel_110:)
	)
	
	(method (sel_178 &tmp temp0)
		(return
			(if (super sel_178: &rest)
				(gIconBar sel_102:)
				(return 1)
			else
				(return 0)
			)
		)
	)
)

(instance checkIcon of Code
	(properties
		sel_20 {checkIcon}
	)
	
	(method (sel_57 param1)
		(if
			(and
				(param1 sel_114: IconI)
				(& (param1 sel_14?) $0004)
			)
			(= global116
				(| global116 (>> $8000 (gIconBar sel_132: param1)))
			)
		)
	)
)

(instance lb2DoVerbCode of Code
	(properties
		sel_20 {lb2DoVerbCode}
	)
	
	(method (sel_57 param1 param2)
		(proc0_6 param2 param1)
	)
)

(instance lb2FtrInit of Code
	(properties
		sel_20 {lb2FtrInit}
	)
	
	(method (sel_57 param1)
		(if (== (param1 sel_301?) 26505) (param1 sel_301: 40))
		(if (== (param1 sel_299?) 26505) (param1 sel_299: 0))
		(if
		(and (not (param1 sel_303?)) (not (param1 sel_304?)))
			(param1
				sel_303: (param1 sel_1?)
				sel_304: (param1 sel_0?)
			)
		)
	)
)

(instance lb2Messager of Messager
	(properties
		sel_20 {lb2Messager}
	)
	
	(method (sel_297 param1 &tmp temp0)
		(if
			(= temp0
				(switch param1
					(99 gNarrator)
					(22 (ScriptID 310 22))
					(20 (ScriptID 1904 20))
					(33 (ScriptID 260 33))
					(14 (ScriptID 1903 14))
					(17 (ScriptID 300 17))
					(16 (ScriptID 1901 16))
					(21
						(if (== gSel_40 750)
							(ScriptID 750 21)
						else
							(ScriptID 1899 21)
						)
					)
					(29 (ScriptID 1884 29))
					(7
						(if (proc0_2 30)
							(ScriptID 230 7)
						else
							(ScriptID 1896 7)
						)
					)
					(1 (ScriptID 1880 1))
					(41 (ScriptID 280 41))
					(23
						(if (== gSel_40 355)
							(ScriptID 355 23)
						else
							(ScriptID 1893 23)
						)
					)
					(8 (ScriptID 1906 8))
					(18 (ScriptID 1889 18))
					(15 (ScriptID 1900 15))
					(2
						(cond 
							((proc0_2 30) (ScriptID 230 2))
							((== gSel_40 155) (ScriptID 155 2))
							((== gSel_40 220) (ScriptID 220 2))
							((== gSel_40 330) (ScriptID 330 2))
							((and (== gSel_40 355) (not (proc0_2 91))) (ScriptID 355 2))
							(
							(and (== gSel_40 710) (== (global2 sel_408?) 716)) (ScriptID 710 2))
							(else (ScriptID 1881 2))
						)
					)
					(4 (ScriptID 1895 4))
					(24 (ScriptID 1907 24))
					(37
						(if (== gSel_40 230) (ScriptID 230 37))
					)
					(36
						(if (== gSel_40 230) (ScriptID 230 37))
					)
					(35
						(if (== gSel_40 230) (ScriptID 230 37))
					)
					(25 (ScriptID 1892 25))
					(19
						(cond 
							((== gSel_40 295) (ScriptID 295 19))
							((== gSel_40 770) (ScriptID 770 19))
							(else (ScriptID 1888 19))
						)
					)
					(30 (ScriptID 310 30))
					(10 (ScriptID 1882 10))
					(27
						(if
						(and (== gSel_40 710) (== (global2 sel_408?) 716))
							(ScriptID 710 27)
						else
							(ScriptID 1891 27)
						)
					)
					(39 (ScriptID 480 39))
					(13 (ScriptID 1902 13))
					(3
						(if (== gSel_40 220)
							(ScriptID 220 3)
						else
							(ScriptID 1894 3)
						)
					)
					(5 (ScriptID 1897 5))
					(31 (ScriptID 310 31))
					(12
						(cond 
							((== gSel_40 240) (ScriptID 240 12))
							((== gSel_40 330) (ScriptID 330 12))
							((== gSel_40 775) (ScriptID 775 12))
							(else (ScriptID 1887 12))
						)
					)
					(32 (ScriptID 260 32))
					(34 (ScriptID 260 34))
					(9 (ScriptID 1883 9))
					(38 (ScriptID 290 38))
					(11 (ScriptID 1886 11))
					(28 (ScriptID 1885 28))
					(6 (ScriptID 1890 6))
				)
			)
			(return)
		else
			(super sel_297: param1)
		)
	)
)

(instance lb2ApproachCode of Code
	(properties
		sel_20 {lb2ApproachCode}
	)
	
	(method (sel_57 param1)
		(switch param1
			(1 1)
			(2 2)
			(3 4)
			(4 8)
			(6 16)
			(13 32)
			(8 64)
			(38 128)
			(else  -32768)
		)
	)
)

(instance lb2Win of SysWindow
	(properties
		sel_20 {lb2Win}
		sel_31 128
	)
	
	(method (sel_189 &tmp temp0 temp1)
		(cond 
			((proc999_5 gSel_40 280 210 330 240 260 300) (= temp1 0))
			(
				(proc999_5
					gSel_40
					210
					220
					230
					260
					270
					280
					290
					295
					300
					310
					320
				)
				(= temp1 1)
			)
			(
				(proc999_5
					gSel_40
					100
					105
					110
					120
					140
					150
					155
					160
					180
					190
					220
					335
					340
					350
					355
					360
					370
					400
				)
				(= temp1 2)
			)
			(
			(proc999_5 gSel_40 460 660 700 710 715 720 730 740) (= temp1 4))
			(
				(proc999_5
					gSel_40
					335
					340
					350
					355
					360
					370
					400
					420
					500
					510
					520
					525
					530
					540
					550
					560
					565
					430
					435
					440
					448
					450
					454
					455
					456
					460
					480
					490
					521
					600
					610
					620
					630
					640
					650
					666
					660
					700
					710
					715
					720
					730
					740
				)
				(= temp1 3)
			)
			(else (= temp1 4))
		)
		(= sel_11 (- sel_194 (/ (CelWide 994 temp1 0) 2)))
		(= sel_10 (- sel_193 (if sel_77 19 else 10)))
		(= sel_13 (+ sel_196 (/ (CelWide 994 temp1 0) 2)))
		(= sel_12
			(proc999_3
				(+ sel_195 3)
				(+ sel_10 (CelHigh 994 temp1 0) 3)
			)
		)
		(= sel_60 15)
		(super sel_189:)
		(= temp0 (GetPort))
		(SetPort 0)
		(Graph
			grFILL_BOX
			sel_193
			sel_194
			sel_195
			sel_196
			3
			global176
			15
		)
		(Graph
			grDRAW_LINE
			(- sel_193 1)
			(- sel_194 1)
			(- sel_193 1)
			sel_196
			global151
			15
		)
		(Graph
			grDRAW_LINE
			(- sel_193 1)
			(- sel_194 1)
			sel_195
			(- sel_194 1)
			global151
			15
		)
		(Graph
			grDRAW_LINE
			sel_195
			(- sel_194 1)
			sel_195
			sel_196
			global151
			15
		)
		(Graph
			grDRAW_LINE
			(- sel_193 1)
			sel_196
			sel_195
			sel_196
			global151
			15
		)
		(Graph grUPDATE_BOX sel_193 sel_194 sel_195 sel_196 1)
		(Graph
			grUPDATE_BOX
			sel_10
			sel_11
			(+ sel_10 (CelHigh 994 temp1 0))
			(+ sel_11 (CelWide 994 temp1 0))
			1
		)
		(Graph
			grUPDATE_BOX
			sel_10
			(- sel_13 (CelWide 994 temp1 0))
			(+ sel_10 (CelHigh 994 temp1 0))
			sel_13
			1
		)
		(DrawCel 994 temp1 0 (+ sel_11 1) (+ sel_10 1) -1)
		(DrawCel
			994
			temp1
			1
			(- (- sel_13 (CelWide 994 temp1 0)) 1)
			(+ sel_10 1)
			-1
		)
		(SetPort temp0)
	)
)
