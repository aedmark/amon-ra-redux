;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 0)
(include sci.sh)
(use invCode)
(use eRS)
(use ego)
(use Print)
(use Messager)
(use Talker)
(use PseudoMouse)
(use IconBar)
(use Osc)
(use PolyPath)
(use Polygon)
(use StopWalk)
(use Timer)
(use Grooper)
(use Window)
(use Sound)
(use Game)
(use Inventory)
(use System)

(public
	LB2 0
	StepOn 1
	IsFlag 2
	SetFlag 3
	ClearFlag 4
	Face 5
	proc0_6 6
	proc0_7 7
	proc0_8 8
	lb2Win 9
	TimeCheck 10
	Localize 11
	proc0_12 12
	proc0_13 13
	proc0_14 14
	proc0_15 15
	proc0_16 16
	proc0_17 17
)

(local
	; 0
	gEgo
	gGame
	gCurRoom
	gSpeed = 6
	gQuit
	; 5
	gCast
	gRegions
	gTimers
	gSounds
	gInventory
	; 10
	gAddToPics
	gCurRoomNum
	gPrevRoomNum
	gNewRoomNum
	gDebugOn
	; 15
	gScore
	gPossibleScore
	global17 = 7
	global18
	gTheCursor
	; 20
	gNormalCursor = 999
	gWaitCursor = 997
	gUserFont = 1
	gSmallFont = 4
	gLastEvent
	; 25
	gModelessDialog
	gBigFont = 1
	gVersion
	gLocales
	gCurSaveDir
	; 30
	global30 = 10
	gPerspective
	gFeatures
	gSFeatures
	gUseSortedFeatures
	; 35
	global35
	gOverlays = -1
	gDoMotionCue
	gSystemWindow
	global39
	; 40
	global40
	gModelessPort
	gSysLogPath
	global43
	global44
	; 45
	global45
	global46
	global47
	global48
	global49
	; 50
	global50
	global51
	global52
	global53
	global54
	; 55
	global55
	global56
	global57
	global58
	global59
	; 60
	global60
	global61
	global62
	gGameControls
	gFtrInitializer
	; 65
	gDoVerbCode
	gLb2ApproachCode
	gUseObstacles = 1
	global68
	gTheIconBar
	; 70
	gMouseX
	gMouseY
	gKeyDownHandler
	gMouseDownHandler
	gDirectionHandler
	; 75
	global75
	gLastVolume
	gPMouse
	gTheDoits
	gEatMice = 60
	; 80
	gUser
	gSyncBias
	gTheSync
	global83
	gFastCast
	; 85
	gInputFont
	gTickOffset
	gHowFast
	gGameTime
	gNarrator
	; 90
	gMsgType
	gMessager
	gPrints
	gWalkHandler
	gTextSpeed = 2
	; 95
	global95
	global96
	global97
	global98
	global99
	; 100
	gStopGroop
	global101 = 1234
	gGameMusic1
	gGameMusic2
	global104
	; 105
	global105
	global106
	global107 = 100
	global108
	global109
	; 110
	global110
	global111
	global112
	global113
	global114
	; 115
	global115
	global116
	global117
	global118
	global119
	; 120
	global120
	global121
	global122
	gAct
	gMustDos
	; 125
	gClockTimeMustDos
	global126
	global127
	global128
	global129
	; 130
	gLb2Exits
	global131 = 1
	global132 = 1
	global133 = 1
	global134 = 1
	; 135
	global135 = 1
	global136
	global137
	global138
	global139
	; 140
	global140
	global141
	global142
	global143
	global144
	; 145
	global145
	global146
	global147
	global148
	global149
	; 150
	global150 = 4
	global151
	global152
	global153
	global154
	; 155
	global155
	global156
	global157
	global158
	global159
	; 160
	global160
	global161
	global162
	global163
	global164
	; 165
	global165
	global166
	global167
	global168
	global169
	; 170
	global170
	global171
	global172
	global173
	global174
	; 175
	global175
	global176
	global177
	global178
	global179
	; 180
	global180
	global181
	global182
	global183
	global184
	; 185
	global185
	global186
	global187
	global188
	global189
	; 190
	global190
	global191
	global192
	global193
	global194
	; 195
	global195
	global196
	global197
	global198
	global199
	; 200
	global200
	global201
	global202
	global203
	global204
	; 205
	global205
	global206
	global207
	global208
	global209
	; 210
	global210
	global211
	global212
	global213
	global214
	; 215
	global215
	global216
	global217
	global218
	global219
	; 220
	global220
	global221
	global222
	global223
	global224
	; 225
	global225
	global226
	global227
	global228
	global229
	; 230
	global230
	global231
	global232
	global233
	global234
	; 235
	global235
	global236
	global237
	global238
	global239
	; 240
	global240
	global241
	global242
	global243
	global244
	; 245
	global245
	global246
	global247
	global248
	global249
	; 250
	global250
	global251
	global252
	global253
	global254
	; 255
	global255
	global256
	global257
	global258
	global259
	; 260
	global260
	global261
	global262
	global263
	global264
	; 265
	global265
	global266
	global267
	global268
	global269
	; 270
	global270
	global271
	global272
	global273
	global274
	; 275
	global275
	global276
	global277
	global278
	global279
	; 280
	global280
	global281
	global282
	global283
	global284
	; 285
	global285
	global286
	global287
	global288
	global289
	; 290
	global290
	global291
	global292
	global293
	global294
	; 295
	global295
	global296
	global297
	global298
	global299
	; 300
	global300
	global301
	global302
	global303
	global304
	; 305
	global305
	global306
	global307
	global308
	global309
	; 310
	global310
	global311
	global312
	global313
	global314
	; 315
	global315
	global316
	global317
	global318
	global319
	; 320
	global320
	global321
	global322
	global323
	global324
	; 325
	global325
	global326
	global327
	global328
	global329
	; 330
	global330
	global331
	global332
	global333
	global334
	; 335
	global335
	global336
	global337
	global338
	global339
	; 340
	global340
	global341
	global342
	global343
	global344
	; 345
	global345
	global346
	global347
	global348
	global349
	; 350
	global350
	global351
	global352
	global353
	global354
	; 355
	global355
	global356
	global357
	global358
	global359
	; 360
	global360
	global361
	global362
	global363
	global364
	; 365
	global365
	global366
	global367
	global368
	global369
	; 370
	global370
	global371
	global372
	global373
	global374
	; 375
	global375
	global376
	global377
	global378
	global379
	; 380
	global380
	global381
	global382
	global383
	global384
	; 385
	global385
	global386
	global387
	global388
	global389
	; 390
	global390
	global391
	global392
	global393
	global394
	; 395
	global395
	global396
	global397
	global398
	global399
)

(procedure (StepOn param1 param2)
	(if (& (param1 sel_337: 1) param2)
		(return 1)
	else
		0
	)
)

(procedure (IsFlag param1)
	(return (& [global186 (/ param1 16)] (>> $8000 (mod param1 16))))
)

(procedure (SetFlag param1 &tmp temp0)
	(= temp0 (IsFlag param1))
	(|= [global186 (/ param1 16)] (>> $8000 (mod param1 16)))
	(return temp0)
)

(procedure (ClearFlag param1 &tmp temp0)
	(= temp0 (IsFlag param1))
	(&= [global186 (/ param1 16)] (~ (>> $8000 (mod param1 16))))
	(return temp0)
)

(procedure (Face param1 param2 param3 param4 &tmp temp0 temp1 temp2 temp3)
	(= temp3 0)
	(if (IsObject param2)
		(= temp1 (param2 sel_1:))
		(= temp2 (param2 sel_0:))
		(if (== argc 3)
			(= temp3 param3)
		)
	else
		(= temp1 param2)
		(= temp2 param3)
		(if (== argc 4)
			(= temp3 param4)
		)
	)
	(= temp0 (GetAngle (param1 sel_1:) (param1 sel_0:) temp1 temp2))
	(param1 sel_253: temp0 (if (IsObject temp3) temp3 else 0))
)

(procedure (proc0_6 param1 param2)
	(cond
		((OneOf param2 4 3 38)
			(gMessager sel_295: 0 param2 0 0 0 0)
		)
		((OneOf param2 6 1 8)
			(gMessager sel_295: 0 param2 0 (Random 1 2) 0 0)
		)
		((== param2 2)
			(gMessager sel_295: 0 param2 0 (Random 1 4) 0 0)
		)
		(else
			(gMessager sel_295: 0 47 0 0 0 0)
		)
	)
)

(procedure (proc0_7 &tmp temp0)
	(gUser sel_237: global108 sel_347: global109)
	(for ((= temp0 0)) (< temp0 8) ((++ temp0))
		(if (& global116 (>> $8000 temp0))
			(gTheIconBar sel_233: temp0)
		)
	)
)

(procedure (proc0_8 param1)
	(if param1
		(gTheIconBar sel_81: icon0 sel_129: (icon10 sel_110: sel_117:))
		(if (== (gTheIconBar sel_207:) icon0)
			(gTheIconBar sel_207: icon10 sel_228: 0)
			(gGame sel_197: (icon10 sel_33:))
		)
	else
		(gTheIconBar sel_81: icon10 sel_129: (icon0 sel_110: sel_117:))
		(if (== (gTheIconBar sel_207:) icon10)
			(gTheIconBar sel_207: icon0 sel_228: icon0)
			(gGame sel_197: (icon0 sel_33:))
		)
	)
)

(procedure (TimeCheck param1 param2)
	(&= param1 $00ff)
	(return
		(if (and (> argc 1) param2)
			(== (- param1 1) (& gMustDos (- param1 1)))
		else
			(& gMustDos param1)
		)
	)
)

(procedure (Localize param1 param2 param3 param4 param5)
	(return
		(switch (gGame sel_84:)
			(49 param1)
			(34 param2)
			(33 param3)
			(39 param4)
			(else param5)
		)
	)
)

(procedure (proc0_12) ; UNUSED
	(Localize 1026 1040 1051 1050 995)
)

(procedure (proc0_13)
	(SetFlag 7)
	(SetFlag 8)
	(SetFlag 9)
	(SetFlag 24)
	(SetFlag 26)
	(SetFlag 27)
	(SetFlag 28)
	(SetFlag 29)
	(SetFlag 34)
	(SetFlag 43)
	((ScriptID 21 0) sel_57: 791) ; addCluesCode
	((ScriptID 21 0) sel_57: 263) ; addCluesCode
	((ScriptID 21 0) sel_57: 264) ; addCluesCode
	((ScriptID 21 0) sel_57: 265) ; addCluesCode
	((ScriptID 21 0) sel_57: 266) ; addCluesCode
	((ScriptID 21 0) sel_57: 267) ; addCluesCode
	((ScriptID 21 0) sel_57: 268) ; addCluesCode
	((ScriptID 21 0) sel_57: 269) ; addCluesCode
	((ScriptID 21 0) sel_57: 270) ; addCluesCode
	((ScriptID 21 0) sel_57: 271) ; addCluesCode
	((ScriptID 21 0) sel_57: 272) ; addCluesCode
	((ScriptID 21 1) sel_57: 518) ; dropCluesCode
	((ScriptID 21 0) sel_57: 520) ; addCluesCode
	(ego sel_584: 1)
	(ego sel_350: -1 22)
	(ego sel_350: -1 6)
)

(procedure (proc0_14)
	(proc0_13)
	(SetFlag 1)
	(SetFlag 25)
	(SetFlag 23)
	((ScriptID 21 0) sel_57: 797) ; addCluesCode
	(ego sel_350: -1 28)
	(ego sel_350: -1 21)
)

(procedure (proc0_15)
	(proc0_14)
	(= global129 13)
	(SetFlag 2)
	(SetFlag 3)
	(SetFlag 4)
	(SetFlag 22)
	(SetFlag 31)
	(SetFlag 33)
	(SetFlag 35)
	(SetFlag 36)
	(SetFlag 37)
	(SetFlag 40)
	(SetFlag 42)
	(SetFlag 49)
	((ScriptID 21 0) sel_57: 790) ; addCluesCode
	((ScriptID 21 0) sel_57: 789) ; addCluesCode
	((ScriptID 21 0) sel_57: 787) ; addCluesCode
	((ScriptID 21 0) sel_57: 783) ; addCluesCode
	((ScriptID 21 0) sel_57: 788) ; addCluesCode
	((ScriptID 21 0) sel_57: 798) ; addCluesCode
	((ScriptID 21 0) sel_57: 802) ; addCluesCode
	((ScriptID 21 0) sel_57: 779) ; addCluesCode
	((ScriptID 21 0) sel_57: 777) ; addCluesCode
	((ScriptID 21 0) sel_57: 776) ; addCluesCode
	((ScriptID 21 0) sel_57: 778) ; addCluesCode
	((ScriptID 21 0) sel_57: 1025) ; addCluesCode
	((ScriptID 21 0) sel_57: 1030) ; addCluesCode
	(ego sel_350: -1 20 18 14 19 29 33 10 8 7 9 11)
)

(procedure (proc0_16 &tmp temp0)
	(proc0_15)
	(SetFlag 72)
	(SetFlag 5)
	(SetFlag 6)
	(SetFlag 62)
	((ScriptID 21 0) sel_57: 794) ; addCluesCode
	((ScriptID 21 0) sel_57: 785) ; addCluesCode
	((ScriptID 21 0) sel_57: 786) ; addCluesCode
	((ScriptID 21 0) sel_57: 799) ; addCluesCode
	((ScriptID 21 0) sel_57: 796) ; addCluesCode
	((ScriptID 21 0) sel_57: 795) ; addCluesCode
	((ScriptID 21 0) sel_57: 781) ; addCluesCode
	((ScriptID 21 0) sel_57: 800) ; addCluesCode
	((ScriptID 21 0) sel_57: 782) ; addCluesCode
	((ScriptID 21 0) sel_57: 780) ; addCluesCode
	(ego sel_351: 6 0 1 3 4 5 8 9 18 23 32)
	((ScriptID 21 1) sel_57: 775) ; dropCluesCode
	((ScriptID 21 1) sel_57: 769) ; dropCluesCode
	((ScriptID 21 1) sel_57: 770) ; dropCluesCode
	((ScriptID 21 1) sel_57: 772) ; dropCluesCode
	((ScriptID 21 1) sel_57: 773) ; dropCluesCode
	((ScriptID 21 1) sel_57: 774) ; dropCluesCode
	((ScriptID 21 1) sel_57: 777) ; dropCluesCode
	((ScriptID 21 1) sel_57: 778) ; dropCluesCode
	((ScriptID 21 1) sel_57: 787) ; dropCluesCode
	((ScriptID 21 1) sel_57: 792) ; dropCluesCode
	((ScriptID 21 1) sel_57: 801) ; dropCluesCode
	(for ((= temp0 1)) (< temp0 27) ((++ temp0))
		((ScriptID 21 0) sel_57: (+ temp0 1088)) ; addCluesCode
	)
	(ego sel_350: -1 25 16 17 30 27 26 12 31 13)
)

(procedure (proc0_17)
	(proc0_16)
	(SetFlag 10)
	((ScriptID 21 0) sel_57: 784) ; addCluesCode
	((ScriptID 21 0) sel_57: 803) ; addCluesCode
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
		sel_608 0
		sel_609 0
		sel_610 0
		sel_94 127
		sel_611 0
	)

	(method (sel_110 param1)
		(Sounds sel_119: 174)
		(if (not sel_608)
			(= sel_608 gGameMusic1)
		)
		(= sel_610 param1)
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
			((OneOf (sel_608 sel_165:) -1 0)
				(= temp0 1)
				(cond
					((and (== sel_610 -1) (== sel_609 (- sel_86 1)))
						(= temp0 -1)
					)
					((== sel_609 sel_86)
						(switch sel_610
							(1
								(= sel_609 0)
							)
							(else
								(self sel_125: sel_111:)
								(return)
							)
						)
					)
				)
				(if (> (= temp1 (self sel_64: sel_609)) 1000)
					(-= temp1 1000)
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
			(sel_611
				(sel_608 sel_168:)
			)
			(else
				(= sel_94 (sel_608 sel_94:))
			)
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
		sel_84 0
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
		(= gVersion {x.yyy.zzz})
		(= global112 {991-999-9999})
		(= global113 {9999-999999})
		(= global114 {992-999-9999})
		((ScriptID 14 0) sel_110:) ; lb2InitCode
		(DisposeScript 14)
		((ScriptID 15 0) sel_110:) ; invCode
		(= gNormalCursor walkCursor)
		(= gDoVerbCode lb2DoVerbCode)
		(= gFtrInitializer lb2FtrInit)
		(= gLb2ApproachCode lb2ApproachCode)
		(= gStopGroop stopGroop)
		(= gMessager lb2Messager)
		((= gKeyDownHandler lb2KDH) sel_118:)
		((= gMouseDownHandler lb2MDH) sel_118:)
		((= gDirectionHandler lb2DH) sel_118:)
		((= gWalkHandler lb2WH) sel_118:)
		((= gLb2Exits lb2Exits) sel_118:)
		((= global95 (List sel_109:)) sel_20: {altPolys} sel_118:)
		(gMouseDownHandler sel_129: lb2Exits)
		(gKeyDownHandler sel_129: lb2Exits)
		(= gPMouse PseudoMouse)
		(WrapMusic sel_118:)
		((= gGameMusic1 gameMusic1) sel_166: self sel_99: 1 sel_110:)
		((= gGameMusic2 gameMusic2) sel_166: self sel_99: 1 sel_110:)
		((= gTheIconBar IconBar)
			sel_118: icon0 icon1 icon2 icon3 icon4 icon6 icon7 icon8 icon9
			sel_119: 110
			sel_119: 211 global157
			sel_119: 212 global177
			sel_207: icon0
			sel_226: icon6
			sel_227: icon9
			sel_228: icon0
			sel_233: 5
			sel_233:
			sel_29: 3072
		)
		(if (GameIsRestarting)
			(MemorySegment 1 @global107) ; MS_RESTORE_TO
		else
			(= global107 28)
		)
		(if (FileIO fiEXISTS {10.scr})
			(= global110 1)
		else
			(= global110 0)
		)
		(gTheIconBar sel_177:)
		(= gEgo ego)
		(gUser sel_341: gEgo sel_237: 0 sel_347: 0)
		(self sel_399: global107)
	)

	(method (sel_57 &tmp temp0 temp1)
		(if
			(and
				(gLb2Exits sel_86:)
				(== (gTheIconBar sel_207:) (gTheIconBar sel_228:))
			)
			(gLb2Exits sel_119: 57)
		)
		(if sel_397
			(= temp0 sel_397)
			(= temp1 sel_398)
			(= sel_397 (= sel_398 0))
			(Eval temp0 temp1)
		)
		(super sel_57:)
	)

	(method (sel_62 &tmp temp0)
		(= gSystemWindow lb2Win)
		(= gNormalCursor walkCursor)
		(if (and (OneOf gCurRoomNum 330 335) (== gAct 2))
			(Palette palSET_INTENSITY 0 255 60)
		else
			(Palette palSET_INTENSITY 0 255 100)
		)
		(super sel_62: &rest)
	)

	(method (sel_399 param1)
		(gGame sel_197: gWaitCursor)
		(gPMouse sel_167:)
		(if (and (== gAct 5) (not (IsFlag 123)))
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
			(SetFlag 123)
		)
		(if gModelessDialog
			(gModelessDialog sel_111:)
		)
		(if (and (IsObject gFastCast) (gFastCast sel_24:))
			(gFastCast sel_119: 111 1)
		)
		(if (gLb2Exits sel_86:)
			(gLb2Exits sel_119: 111)
		)
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
		(gTheIconBar sel_233:)
		(super sel_399: param1)
	)

	(method (sel_400 param1 &tmp temp0 temp1 [temp2 2])
		((ScriptID 11) sel_57: param1) ; disposeCode
		(for ((= temp1 0)) (< temp1 (gTimers sel_86:)) ((++ temp1))
			(gTimers sel_81: (= temp0 (gTimers sel_64: 0)))
			(gTimers sel_118: temp0)
		)
		(for ((= temp1 0)) (< temp1 (WrapMusic sel_86:)) ((++ temp1))
			(WrapMusic sel_81: (= temp0 (WrapMusic sel_64: 0)))
			(WrapMusic sel_118: temp0)
		)
		(if
			(and
				(!= (- (MemoryInfo 1) 2) (MemoryInfo 0)) ; FreeHeap, LargestPtr
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
				(OneOf
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
				(!= gAct 5)
			)
			(ScriptID 90) ; MuseumRgn
		)
		(if
			(and
				(OneOf param1 335 340 350 355 360 370 400)
				(== gAct 2)
			)
			(ScriptID 93) ; RotundaRgn
		)
		(if (OneOf param1 280 210 260 300)
			(ScriptID 91) ; streetRgn
		)
		(if
			(and
				(== gAct 5)
				(OneOf param1 420 430 435 440 448 450 454 460 480 490 660)
			)
			(ScriptID 94) ; PursuitRgn
		)
		(if (OneOf param1 100 105 110 120 140 150 155 160 180 190 220)
			(ScriptID 92) ; intro
		)
		(if (and global110 (not (OneOf param1 100)))
			((ScriptID 10 0) sel_110:) ; MISSING SCRIPT
		)
		(gTheIconBar sel_177:)
		(super sel_400: param1)
		(if
			(and
				(gEgo sel_245:)
				(not (gEgo sel_59:))
				((gEgo sel_245:) sel_114: StopWalk)
			)
			(gEgo sel_155: stopGroop)
		)
		(if (== (gTheIconBar sel_207:) (gTheIconBar sel_64: 5))
			(gTheIconBar sel_207: (gTheIconBar sel_64: 0))
		)
	)

	(method (sel_101)
		(gCurRoom sel_28: 6 sel_417: 780)
		(gCast sel_119: 102)
		(Animate (gCast sel_24:) 0)
		(MemorySegment 0 @global107 2) ; MS_SAVE_FROM
		(super sel_101:)
	)

	(method (sel_76 &tmp temp0 temp1 temp2 temp3)
		(= temp3 (EventHandler sel_109:))
		(for ((= temp2 0)) (< temp2 (gAddToPics sel_86:)) ((++ temp2))
			(temp3 sel_118: (gAddToPics sel_64: temp2))
		)
		(DrawPic 780 7)
		(gCast sel_119: 102)
		(Animate 0)
		(= temp1 gNormalCursor)
		(= gNormalCursor 999)
		(= temp0 gSystemWindow)
		(= gSystemWindow SysWindow)
		(super sel_76: &rest)
		(DrawPic (gCurRoom sel_408:) 100)
		(gCast sel_119: 216)
		(for ((= temp2 0)) (< temp2 (temp3 sel_86:)) ((++ temp2))
			(gAddToPics sel_118: (temp3 sel_64: temp2))
		)
		(temp3 sel_125: sel_111:)
		(gAddToPics sel_57:)
		(Animate (gCast sel_24:) 0)
		(= gSystemWindow temp0)
		(= gNormalCursor temp1)
		(if (== (= temp2 ((gTheIconBar sel_207:) sel_33:)) 999)
			(gGame sel_197: gWaitCursor)
		else
			(gGame sel_197: temp2)
		)
	)

	(method (sel_75 &tmp temp0 temp1 temp2)
		(= temp1 gNormalCursor)
		(= gNormalCursor 999)
		(= temp0 gSystemWindow)
		(= gSystemWindow SysWindow)
		(super sel_75: &rest)
		(= gSystemWindow temp0)
		(= gNormalCursor temp1)
		(if (== (= temp2 ((gTheIconBar sel_207:) sel_33:)) 999)
			(gGame sel_197: gWaitCursor)
		else
			(gGame sel_197: temp2)
		)
	)

	(method (sel_133 param1)
		(if (param1 sel_73:)
			(return 1)
		)
		(return
			(switch (param1 sel_31:)
				(4
					(switch (param1 sel_37:)
						(9
							(if (not (& ((gTheIconBar sel_64: 6) sel_14:) $0004))
								(if gFastCast
									(return gFastCast)
								)
								(gEgo sel_586:)
								(param1 sel_73: 1)
							)
						)
						(3840
							(if (not (& ((gTheIconBar sel_64: 6) sel_14:) $0004))
								(if gFastCast
									(return gFastCast)
								)
								(gEgo sel_586:)
								(param1 sel_73: 1)
							)
						)
						(17
							(gGame sel_100:)
							(param1 sel_73: 1)
						)
						(3
							(if (not (& ((gTheIconBar sel_64: 7) sel_14:) $0004))
								(gGame sel_612:)
							)
						)
						(15360
							(cond
								((gGame sel_404:)
									(gGame sel_404: 0)
								)
								((> global106 1)
									(gGame sel_404: 15)
								)
								(else
									(gGame sel_404: 1)
								)
							)
							(param1 sel_73: 1)
						)
						(16128
							(if (not (& ((gTheIconBar sel_64: 7) sel_14:) $0004))
								(if gFastCast
									(return gFastCast)
								)
								(gGame sel_75:)
								(param1 sel_73: 1)
							)
						)
						(16640
							(if (not (& ((gTheIconBar sel_64: 7) sel_14:) $0004))
								(if gFastCast
									(return gFastCast)
								)
								(gGame sel_76:)
								(param1 sel_73: 1)
							)
						)
						(43
							(if (gUser sel_343:)
								(= gSpeed (Max 0 (-- gSpeed)))
								(gEgo sel_352: gSpeed)
							)
						)
						(45
							(if (gUser sel_343:)
								(++ gSpeed)
								(gEgo sel_352: gSpeed)
							)
						)
						(61
							(if (gUser sel_343:)
								(gEgo sel_352: 6)
							)
						)
					)
				)
			)
		)
	)

	(method (sel_197 param1 param2 param3 param4 &tmp temp0)
		(= temp0 gTheCursor)
		(if argc
			(if (IsObject param1)
				((= gTheCursor param1) sel_110:)
			else
				(SetCursor (= gTheCursor param1) 0 0)
			)
		)
		(if (and (> argc 1) (not param2))
			(SetCursor 996 0 0)
		)
		(if (> argc 2)
			(if (< param3 0)
				(= param3 0)
			)
			(if (< param4 0)
				(= param4 0)
			)
			(SetCursor param3 param4)
		)
		(return temp0)
	)

	(method (sel_402))

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
		(if gModelessDialog
			(gModelessDialog sel_111:)
		)
		(if (gUser sel_347:)
			(gMessager sel_295: 0 ((gUser sel_346:) sel_37:))
		)
	)

	(method (sel_587)
		(if (not global121)
			(= global121 (gTheIconBar sel_207:))
		)
		(= global108 (gUser sel_237:))
		(= global109 (gUser sel_347:))
		(gUser sel_237: 0 sel_347: 0)
		(gEgo sel_312: 0)
		(= global116 0)
		(gTheIconBar sel_119: 96 checkIcon)
		(gTheIconBar sel_207: (gTheIconBar sel_64: 7))
		(gTheIconBar sel_233: 0 1 2 3 4 5 6)
		(if (not (HaveMouse))
			(gGame sel_197: 996)
		else
			(gGame sel_197: gWaitCursor)
		)
	)

	(method (sel_588 param1)
		(gUser sel_237: 1 sel_347: 1)
		(gTheIconBar sel_177: 0 1 2 3 4 5 6)
		(gTheIconBar sel_177: 7)
		(if (and argc param1)
			(proc0_7)
		)
		(if (not (gTheIconBar sel_225:))
			(gTheIconBar sel_233: 5)
		)
		(if
			(and
				global121
				(or (!= global121 icon10) (== (gTheIconBar sel_64: 0) icon10))
			)
			(gTheIconBar sel_207: global121)
			(gGame sel_197: (global121 sel_33:))
			(if
				(and
					(== (gTheIconBar sel_207:) (gTheIconBar sel_64: 5))
					(not (gTheIconBar sel_225:))
				)
				(gTheIconBar sel_231:)
			)
		)
		(= global121 0)
		(gGame sel_197: ((gTheIconBar sel_207:) sel_33:) 1)
	)

	(method (sel_87 param1 param2)
		(if (and (> argc 1) (SetFlag param2))
			(= param1 0)
		)
		(if param1
			(gGame sel_388: param1)
		)
	)

	(method (sel_612 &tmp temp0)
		((ScriptID 24 0) sel_110: sel_216: sel_111:) ; lb2GameControls
	)

	(method (sel_613)
		(if (OneOf gCurRoomNum 435 454 455 520 521 525 550 560 565 620 650) ; meanWhile
			(gMessager sel_295: 11 0 0 0 0 0)
		else
			((ScriptID 13 0) sel_57:) ; aboutCode
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
		(if (super sel_178: &rest)
			(gTheIconBar sel_102:)
			(return 1)
		else
			(return 0)
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

	(method (sel_178 param1 &tmp temp0 temp1 temp2 temp3 temp4)
		(return
			(cond
				((& sel_14 $0004) 0)
				((and argc param1 (& sel_14 $0001))
					(if (= temp2 (gTheIconBar sel_225:))
						(= temp3
							(+
								(/
									(-
										(- sel_9 sel_7)
										(CelWide
											(temp2 sel_2:)
											(+ (temp2 sel_3:) 1)
											(temp2 sel_4:)
										)
									)
									2
								)
								sel_7
							)
						)
						(= temp4
							(+
								(gTheIconBar sel_0:)
								(/
									(-
										(- sel_8 sel_6)
										(CelHigh
											(temp2 sel_2:)
											(+ (temp2 sel_3:) 1)
											(temp2 sel_4:)
										)
									)
									2
								)
								sel_6
							)
						)
					)
					(DrawCel sel_2 sel_3 (= temp1 1) sel_7 sel_6 -1)
					(if (= temp2 (gTheIconBar sel_225:))
						(DrawCel
							(temp2 sel_2:)
							(+ 1 (temp2 sel_3:))
							(temp2 sel_4:)
							temp3
							temp4
							-1
						)
					)
					(Graph grUPDATE_BOX sel_6 sel_7 sel_8 sel_9 1)
					(while (!= ((= temp0 (Event sel_109:)) sel_31:) 2)
						(temp0 sel_148:)
						(cond
							((self sel_218: temp0)
								(if (not temp1)
									(DrawCel
										sel_2
										sel_3
										(= temp1 1)
										sel_7
										sel_6
										-1
									)
									(if (= temp2 (gTheIconBar sel_225:))
										(DrawCel
											(temp2 sel_2:)
											(+ 1 (temp2 sel_3:))
											(temp2 sel_4:)
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
								(if (= temp2 (gTheIconBar sel_225:))
									(DrawCel
										(temp2 sel_2:)
										(+ 1 (temp2 sel_3:))
										(temp2 sel_4:)
										temp3
										temp4
										-1
									)
								)
								(Graph grUPDATE_BOX sel_6 sel_7 sel_8 sel_9 1)
							)
						)
						(temp0 sel_111:)
					)
					(temp0 sel_111:)
					(if (== temp1 1)
						(DrawCel sel_2 sel_3 0 sel_7 sel_6 -1)
						(if (= temp2 (gTheIconBar sel_225:))
							(DrawCel
								(temp2 sel_2:)
								(+ 1 (temp2 sel_3:))
								(temp2 sel_4:)
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
		(= sel_3 (if (gEgo sel_584:) 11 else 6))
		(super sel_216: &rest)
	)

	(method (sel_178)
		(if (super sel_178: &rest)
			(gTheIconBar sel_102:)
			(gEgo sel_586:)
			(return 1)
		else
			(return 0)
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
		(if (super sel_178: &rest)
			(gTheIconBar sel_102:)
			(gGame sel_612:)
			(return 1)
		else
			(return 0)
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
		(if (super sel_178: &rest)
			(gTheIconBar sel_102:)
			(return 1)
		else
			(return 0)
		)
	)
)

(instance checkIcon of Code
	(properties
		sel_20 {checkIcon}
	)

	(method (sel_57 param1)
		(if (and (param1 sel_114: IconI) (& (param1 sel_14:) $0004))
			(|= global116 (>> $8000 (gTheIconBar sel_132: param1)))
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
		(if (== (param1 sel_301:) 26505)
			(param1 sel_301: 40)
		)
		(if (== (param1 sel_299:) 26505)
			(param1 sel_299: 0)
		)
		(if (and (not (param1 sel_303:)) (not (param1 sel_304:)))
			(param1 sel_303: (param1 sel_1:) sel_304: (param1 sel_0:))
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
					(22
						(ScriptID 310 22) ; Bartender
					)
					(20
						(ScriptID 1904 20) ; Talking_Bear
					)
					(33
						(ScriptID 260 33) ; Biff
					)
					(14
						(ScriptID 1903 14) ; Bob
					)
					(17
						(ScriptID 300 17) ; Bouncer
					)
					(16
						(ScriptID 1901 16) ; Bum
					)
					(21
						(if (== gCurRoomNum 750)
							(ScriptID 750 21) ; Coroner
						else
							(ScriptID 1899 21) ; Coroner
						)
					)
					(29
						(ScriptID 1884 29) ; Countess
					)
					(7
						(if (IsFlag 30)
							(ScriptID 230 7) ; Crodfoller
						else
							(ScriptID 1896 7) ; Crodfoller
						)
					)
					(1
						(ScriptID 1880 1) ; Dad
					)
					(41
						(ScriptID 280 41) ; Drunk
					)
					(23
						(if (== gCurRoomNum 355)
							(ScriptID 355 23) ; tkrErnie
						else
							(ScriptID 1893 23) ; Ernie
						)
					)
					(8
						(ScriptID 1906 8) ; Lesbian_Flapper
					)
					(18
						(ScriptID 1889 18) ; Heimlich
					)
					(15
						(ScriptID 1900 15) ; Irmgaard
					)
					(2
						(cond
							((IsFlag 30)
								(ScriptID 230 2) ; Laura
							)
							((== gCurRoomNum 155)
								(ScriptID 155 2) ; Laura
							)
							((== gCurRoomNum 220)
								(ScriptID 220 2) ; Laura220
							)
							((== gCurRoomNum 330)
								(ScriptID 330 2) ; Laura
							)
							((and (== gCurRoomNum 355) (not (IsFlag 91)))
								(ScriptID 355 2) ; tkrLaura
							)
							((and (== gCurRoomNum 710) (== (gCurRoom sel_408:) 716))
								(ScriptID 710 2) ; Rameses_b
							)
							(else
								(ScriptID 1881 2) ; Laura
							)
						)
					)
					(4
						(ScriptID 1895 4) ; Lo_Fat
					)
					(24
						(ScriptID 1907 24) ; Luigi
					)
					(37
						(if (== gCurRoomNum 230)
							(ScriptID 230 37) ; ManWriting
						)
					)
					(36
						(if (== gCurRoomNum 230)
							(ScriptID 230 37) ; ManWriting
						)
					)
					(35
						(if (== gCurRoomNum 230)
							(ScriptID 230 37) ; ManWriting
						)
					)
					(25
						(ScriptID 1892 25) ; Olympia
					)
					(19
						(cond
							((== gCurRoomNum 295)
								(ScriptID 295 19) ; myORiley
							)
							((== gCurRoomNum 770)
								(ScriptID 770 19) ; O_Riley
							)
							(else
								(ScriptID 1888 19) ; O_Riley
							)
						)
					)
					(30
						(ScriptID 310 30) ; PianoPlayer
					)
					(10
						(ScriptID 1882 10) ; Pippin
					)
					(27
						(if (and (== gCurRoomNum 710) (== (gCurRoom sel_408:) 716))
							(ScriptID 710 27) ; Rameses_a
						else
							(ScriptID 1891 27) ; Rameses
						)
					)
					(39
						(ScriptID 480 39) ; Rex
					)
					(13
						(ScriptID 1902 13) ; Rocco
					)
					(3
						(if (== gCurRoomNum 220)
							(ScriptID 220 3) ; Sam220
						else
							(ScriptID 1894 3) ; Sam
						)
					)
					(5
						(ScriptID 1897 5) ; Sergeant
					)
					(31
						(ScriptID 310 31) ; Singer
					)
					(12
						(cond
							((== gCurRoomNum 240)
								(ScriptID 240 12) ; local_Steve
							)
							((== gCurRoomNum 330)
								(ScriptID 330 12) ; Steve
							)
							((== gCurRoomNum 775)
								(ScriptID 775 12) ; Steve
							)
							(else
								(ScriptID 1887 12) ; Steve
							)
						)
					)
					(32
						(ScriptID 260 32) ; Stinky
					)
					(34
						(ScriptID 260 34) ; Tubby
					)
					(9
						(ScriptID 1883 9) ; TutSmith
					)
					(38
						(ScriptID 290 38) ; theWanderer
					)
					(11
						(ScriptID 1886 11) ; Watney
					)
					(28
						(ScriptID 1885 28) ; Yvette
					)
					(6
						(ScriptID 1890 6) ; Ziggy
					)
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
		(return
			(switch param1
				(1 1)
				(2 2)
				(3 4)
				(4 8)
				(6 16)
				(13 32)
				(8 64)
				(38 128)
				(else -32768)
			)
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
			((OneOf gCurRoomNum 280 210 330 240 260 300)
				(= temp1 0)
			)
			((OneOf gCurRoomNum 210 220 230 260 270 280 290 295 300 310 320)
				(= temp1 1)
			)
			(
				(OneOf
					gCurRoomNum
					100
					105 ; logo
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
					340 ; testRoom
					350
					355
					360
					370
					400
				)
				(= temp1 2)
			)
			((OneOf gCurRoomNum 460 660 700 710 715 720 730 740)
				(= temp1 4)
			)
			(
				(OneOf
					gCurRoomNum
					335
					340 ; testRoom
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
					456 ; magRosetta
					460
					480
					490
					521 ; meanWhile
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
			(else
				(= temp1 4)
			)
		)
		(= sel_11 (- sel_194 (/ (CelWide 994 temp1 0) 2)))
		(= sel_10 (- sel_193 (if sel_77 19 else 10)))
		(= sel_13 (+ sel_196 (/ (CelWide 994 temp1 0) 2)))
		(= sel_12 (Max (+ sel_195 3) (+ sel_10 (CelHigh 994 temp1 0) 3)))
		(= sel_60 15)
		(super sel_189:)
		(= temp0 (GetPort))
		(SetPort 0)
		(Graph grFILL_BOX sel_193 sel_194 sel_195 sel_196 3 global176 15)
		(Graph grDRAW_LINE (- sel_193 1) (- sel_194 1) (- sel_193 1) sel_196 global151 15)
		(Graph grDRAW_LINE (- sel_193 1) (- sel_194 1) sel_195 (- sel_194 1) global151 15)
		(Graph grDRAW_LINE sel_195 (- sel_194 1) sel_195 sel_196 global151 15)
		(Graph grDRAW_LINE (- sel_193 1) sel_196 sel_195 sel_196 global151 15)
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
