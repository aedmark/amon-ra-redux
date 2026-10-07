;;; Sierra Script 1.0 - (do not remove this comment)
(script# 19)
(include sci.sh)
(use Main)
(use StopWalk)
(use SysWindow)
(use InvI)
(use User)


(class ego of Ego
	(properties
		sel_20 {ego}
		sel_1 0
		sel_0 0
		sel_82 0
		sel_55 0
		sel_213 1
		sel_214 19
		sel_6 0
		sel_7 0
		sel_8 0
		sel_9 0
		sel_301 180
		sel_299 0
		sel_302 26505
		sel_303 0
		sel_304 0
		sel_305 0
		sel_306 0
		sel_52 2
		sel_2 800
		sel_3 0
		sel_4 0
		sel_60 0
		sel_5 0
		sel_14 8192
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
		sel_15 -32768
		sel_249 0
		sel_250 0
		sel_51 3
		sel_323 770
		sel_53 6
		sel_324 0
		sel_325 0
		sel_56 0
		sel_59 0
		sel_326 0
		sel_327 0
		sel_328 0
		sel_349 0
		sel_584 0
	)
	
	(method (sel_350 param1)
		(if (== param1 -1)
			(super sel_350: &rest)
		else
			(super sel_350: param1 &rest)
			(gLb2Messager sel_295: 2 4 0 0 0 19)
		)
	)
	
	(method (sel_351)
		(if
			(and
				(not (gUser sel_237:))
				(== gGIconBarSel_207 (gIconBar sel_64: 5))
			)
			(= gGIconBarSel_207 (gIconBar sel_64: 0))
			(gGame sel_197: global21)
		)
		(super sel_351: &rest)
	)
	
	(method (sel_585 param1)
		(= sel_2 (if argc param1 else 800))
		(self
			sel_155: -1
			sel_156: -1
			sel_63: -1
			sel_312: 0
			sel_161: StopWalk -1
			sel_338: 3 2
			sel_82: 0
			sel_15: -32768
			sel_316: 0
			sel_352: global3
		)
	)
	
	(method (sel_586 &tmp theGLb2Win)
		(if (Inv sel_120: 353 gEgo)
			(= theGLb2Win gLb2Win)
			(= gLb2Win SysWindow)
			(Inv sel_113: gEgo)
			(if (not (gIconBar sel_225?))
				(gIconBar sel_207: (gIconBar sel_64: 0) sel_233: 5)
				(if (& ((gIconBar sel_207?) sel_14?) $0004)
					(gIconBar sel_231:)
				)
				(gGame sel_197: ((gIconBar sel_207?) sel_33?))
			)
			(= gLb2Win theGLb2Win)
			(gNarrator sel_540: 0 sel_20: {Narrator})
		else
			(gLb2Messager sel_295: 1 0 1 0 0 19)
		)
	)
)
